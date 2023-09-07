package com.kot.ordering.service.user_detail;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kot.ordering.entity.OrderEntity;
import com.kot.ordering.entity.UserDetailEntity;
import com.kot.ordering.model.UserDetail;
import com.kot.ordering.repository.UserDetailRepository;

@Service
public class UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    public UserDetailEntity create(UserDetail model, OrderEntity orderEntity) {
        UserDetailEntity entity = model.getEntity();
        entity.setOrder(orderEntity);
        return userDetailRepository.save(entity);
    }

    public UserDetail findByOrderId(UUID orderId) {
        UserDetailEntity userDetail = userDetailRepository.findByOrder_Id(orderId);
        if (userDetail == null) {
            return null;
        }
        return new UserDetail(userDetail);
    }
}
