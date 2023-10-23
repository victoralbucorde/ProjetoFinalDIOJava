INSERT INTO tb_account (id, number, agency, balance, additional_limit)
VALUES (1, '123456789', 'ABC123', 1000.00, 500.00);

INSERT INTO tb_card (id, number, available_limit)
VALUES (3, '3209302', 2000.00);

INSERT INTO tb_feature (id, icon, description)
VALUES (1, 'item icon teste', 'item description teste');
INSERT INTO tb_feature (id, icon, description)
VALUES (2, 'item icon teste', 'item description teste');

INSERT INTO tb_news (id, icon, description)
VALUES (1, 'item icon teste news', 'item description teste news');

INSERT INTO tb_user (id, name, account_id, card_id)
VALUES (1, 'John Doe', 1, 3);

INSERT INTO tb_user_features (tb_user_id, features_id)
VALUES (1, 1);

INSERT INTO tb_user_features (tb_user_id, features_id)
VALUES (1, 2);
