INSERT INTO `loyal`.`badge_details` (`badge_name`, `badge_description`, `algo_type`, `algo_id`, `active`, `created_date`) VALUES ('Badge-1', 'My descr-1', 'TBOP', 'TBOP-1', 'Y', '2013-09-02 00:00:00');
INSERT INTO `loyal`.`badge_details` (`badge_name`, `badge_description`, `algo_type`, `algo_id`, `active`, `created_date`) VALUES ('Badge-2', 'My descr-2', 'TBOP', 'TBOP-2', 'Y', '2013-09-02 00:00:00');
INSERT INTO `loyal`.`badge_details` (`badge_name`, `badge_description`, `algo_type`, `algo_id`, `active`, `created_date`) VALUES ('Badge-3', 'My descr-3', 'TROG', 'TROG-1', 'Y', '2013-09-02 00:00:00');
INSERT INTO `loyal`.`badge_details` (`badge_name`, `badge_description`, `algo_type`, `algo_id`, `active`, `created_date`) VALUES ('Badge-4', 'My descr-4', 'TROG', 'TROG-2', 'Y', '2013-09-02 00:00:00');
INSERT INTO `loyal`.`badge_details` (`badge_name`, `badge_description`, `algo_type`, `algo_id`, `active`, `created_date`) VALUES ('Badge-5', 'My descr-5', 'TROG', 'TROG-3', 'Y', '2013-09-02 00:00:00');
INSERT INTO `loyal`.`badge_details` (`badge_name`, `badge_description`, `algo_type`, `algo_id`, `active`, `created_date`) VALUES ('Badge-6', 'My descr-6', 'TROG', 'TROG-4', 'Y', '2013-09-02 00:00:00');
INSERT INTO `loyal`.`badge_details` (`badge_name`, `badge_description`, `algo_type`, `algo_id`, `active`, `created_date`) VALUES ('Badge-7', 'My descr-7', 'TROG', 'TROG-5', 'Y', '2013-09-02 00:00:00');
INSERT INTO `loyal`.`badge_details` (`badge_name`, `badge_description`, `algo_type`, `algo_id`, `active`, `created_date`) VALUES ('Badge-8', 'My descr-8', 'TBOP', 'TBOP-3', 'Y', '2013-09-02 00:00:00');
INSERT INTO `loyal`.`badge_details` (`badge_name`, `badge_description`, `algo_type`, `algo_id`, `active`, `created_date`) VALUES ('Badge-9', 'My descr-9', 'TBOP', 'TBOP-4', 'Y', '2013-09-02 00:00:00');
INSERT INTO `loyal`.`badge_details` (`badge_name`, `badge_description`, `algo_type`, `algo_id`, `active`, `created_date`) VALUES ('Badge-10', 'My descr-10', 'TBOP', 'TBOP-5', 'Y', '2013-09-02 00:00:00');


INSERT INTO `loyal`.`algo_totalbetonprovider` (`algo_id`, `providers`, `games`, `bet_amount`, `no_of_days`) VALUES ('TBOP-1', '1', '1', '100.00', '2');
INSERT INTO `loyal`.`algo_totalbetonprovider` (`algo_id`, `providers`, `games`, `bet_amount`, `no_of_days`) VALUES ('TBOP-2', '1', '1', '200.00', '3');
INSERT INTO `loyal`.`algo_totalbetonprovider` (`algo_id`, `providers`, `games`, `bet_amount`, `no_of_days`) VALUES ('TBOP-3', '0', '1', '300.00', '5');
INSERT INTO `loyal`.`algo_totalbetonprovider` (`algo_id`, `providers`, `games`, `bet_amount`, `no_of_days`) VALUES ('TBOP-4', '0', '1', '150.00', '3');
INSERT INTO `loyal`.`algo_totalbetonprovider` (`algo_id`, `providers`, `games`, `bet_amount`, `no_of_days`) VALUES ('TBOP-5', '1', '1', '50.00', '9');

INSERT INTO `loyal`.`algo_totalroundsongame` (`algo_id`, `providers`, `games`, `no_of_game_rounds`, `no_of_days`) VALUES ('TROG-1', '1', '1', 100, '2');
INSERT INTO `loyal`.`algo_totalroundsongame` (`algo_id`, `providers`, `games`, `no_of_game_rounds`, `no_of_days`) VALUES ('TROG-2', '1', '1', 50, '3');
INSERT INTO `loyal`.`algo_totalroundsongame` (`algo_id`, `providers`, `games`, `no_of_game_rounds`, `no_of_days`) VALUES ('TROG-3', '0', '1', 150, '5');
INSERT INTO `loyal`.`algo_totalroundsongame` (`algo_id`, `providers`, `games`, `no_of_game_rounds`, `no_of_days`) VALUES ('TROG-4', '0', '1', 75, '3');
INSERT INTO `loyal`.`algo_totalroundsongame` (`algo_id`, `providers`, `games`, `no_of_game_rounds`, `no_of_days`) VALUES ('TROG-5', '1', '0', 500, '9');


INSERT INTO `loyal`.`algo_games` (`algo_id`, `algo_type`, `game`, `active`) VALUES ('TROG-1', 'TROG', 'game1', 'Y');
INSERT INTO `loyal`.`algo_games` (`algo_id`, `algo_type`, `game`, `active`) VALUES ('TROG-2', 'TROG', 'game2', 'Y');
INSERT INTO `loyal`.`algo_games` (`algo_id`, `algo_type`, `game`, `active`) VALUES ('TROG-2', 'TROG', 'game3', 'Y');
INSERT INTO `loyal`.`algo_games` (`algo_id`, `algo_type`, `game`, `active`) VALUES ('TROG-5', 'TROG', 'game4', 'Y');
INSERT INTO `loyal`.`algo_games` (`algo_id`, `algo_type`, `game`, `active`) VALUES ('TROG-5', 'TROG', 'game5', 'Y');
INSERT INTO `loyal`.`algo_games` (`algo_id`, `algo_type`, `game`, `active`) VALUES ('TROG-5', 'TROG', 'game6', 'Y');

INSERT INTO `loyal`.`algo_providers` (`algo_id`, `algo_type`, `provider`, `active`) VALUES ('TBOP-1', 'TBOP', 'provider1', 'Y');
INSERT INTO `loyal`.`algo_providers` (`algo_id`, `algo_type`, `provider`, `active`) VALUES ('TBOP-1', 'TBOP', 'provider2', 'Y');
INSERT INTO `loyal`.`algo_providers` (`algo_id`, `algo_type`, `provider`, `active`) VALUES ('TBOP-2', 'TBOP', 'provider3', 'Y');
INSERT INTO `loyal`.`algo_providers` (`algo_id`, `algo_type`, `provider`, `active`) VALUES ('TBOP-5', 'TBOP', 'provider4', 'Y');
INSERT INTO `loyal`.`algo_providers` (`algo_id`, `algo_type`, `provider`, `active`) VALUES ('TROG-1', 'TROG', 'provider1', 'Y');
INSERT INTO `loyal`.`algo_providers` (`algo_id`, `algo_type`, `provider`, `active`) VALUES ('TROG-2', 'TROG', 'provider2', 'Y');
INSERT INTO `loyal`.`algo_providers` (`algo_id`, `algo_type`, `provider`, `active`) VALUES ('TROG-2', 'TROG', 'provider3', 'Y');
INSERT INTO `loyal`.`algo_providers` (`algo_id`, `algo_type`, `provider`, `active`) VALUES ('TROG-5', 'TROG', 'provider4', 'Y');
