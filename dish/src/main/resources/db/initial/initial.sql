CREATE TABLE ffp_ordering
(
    id                  SERIAL PRIMARY KEY,
    created_date        TIMESTAMP WITH TIME ZONE NOT NULL,
    last_modified_date  TIMESTAMP WITH TIME ZONE,
    total_price         NUMERIC(19, 2)           NOT NULL,
    card_name           VARCHAR(255)             NOT NULL,
    card_number         VARCHAR(255)             NOT NULL,
    expiration          VARCHAR(255)             NOT NULL,
    cvv                 VARCHAR(255)             NOT NULL,
    payment_method      VARCHAR(255)             NOT NULL,
    selected_dishes     INTEGER[],
    selected_categories VARCHAR[],
    UNIQUE (card_number),
    CHECK (payment_method IN ('CREDIT_CARD', 'CASH'))
) WITH ( OIDS = FALSE)
    TABLESPACE pg_default;
ALTER TABLE ffp_ordering OWNER to ffp_ordering_user;

