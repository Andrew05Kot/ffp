package com.kot.establishment.filtering.criteria_parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.kot.establishment.filtering.exception.IllegalFilteringOperationException;


@Service
public class FilteringCriteriaParser {

	private static final Logger LOG = LoggerFactory.getLogger(FilteringCriteriaParser.class);
	private static final Pattern PATTERN = Pattern.compile("(\\w+?)(:|!_=|[!<>_]=?|=)(.*)");

	private final ConversionService conversionService;

	@Autowired
	public FilteringCriteriaParser(ConversionService conversionService) {
		this.conversionService = conversionService;
	}

	public List<FilteringCriteria> parseSearchCriteria(String searchQuery, List<FilteringProperty> filterableProperties) {
		String[] searchParams = searchQuery.split(",");
		List<FilteringCriteria> searchCriteria = new ArrayList<>();

		for (String searchParameter : searchParams) {
			Matcher matcher = PATTERN.matcher(searchParameter);
			while (matcher.find()) {
				String key = matcher.group(1);
				String operationStr = matcher.group(2);
				FilteringOperation operation = FilteringOperation.fromString(operationStr);
				String value = matcher.group(3);

				Optional<FilteringProperty> filterableProperty = filterableProperties.stream().filter(
						property -> property.propertyName().equals(key)
				).findFirst();

				if (filterableProperty.isPresent()) {
					Object convertedValue;
					if ("null".equals(value) || StringUtils.isEmpty(value)) {
						convertedValue = null;
					} else {
						convertedValue = conversionService.convert(value, filterableProperty.get().expectedType());
					}
					if (!filterableProperty.get().operators().contains(operation)) {
						throw new IllegalFilteringOperationException("Operation '" + operation + "' is not supported for property " + key);
					}
					searchCriteria.add(new FilteringCriteria(key, operation, convertedValue));
				} else {
					LOG.warn("Filtering on property '{}' has been skipped because it's absent in filterableProperties", key);
				}
			}
		}
		return searchCriteria;
	}
}
