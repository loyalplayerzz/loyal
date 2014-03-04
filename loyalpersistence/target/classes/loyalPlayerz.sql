CREATE TABLE `loyal`.`badge_details` (
  `badge_id` INT NOT NULL AUTO_INCREMENT,
  `badge_name` VARCHAR(75) NOT NULL,
  `badge_description` VARCHAR(200) NULL,
  `algo_type` VARCHAR(10) NOT NULL,
  `algo_id` VARCHAR(10) NOT NULL,
  `active` CHAR NOT NULL DEFAULT 'Y',
  `created_date` DATETIME NOT NULL,
  PRIMARY KEY (`badge_id`));
  
  CREATE TABLE `loyal`.`algo_totalbetonprovider` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `algo_id` VARCHAR(10) NOT NULL,
  `providers` INT NOT NULL,
  `games` INT NOT NULL,
  `bet_amount` DECIMAL(10,6) NOT NULL,
  `no_of_days` INT NOT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `loyal`.`algo_totalroundsongame` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `algo_id` VARCHAR(10) NOT NULL,
  `providers` INT NOT NULL,
  `games` INT NOT NULL,
  `no_of_game_rounds` INT NOT NULL,
  `no_of_days` INT NOT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `loyal`.`algo_providers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `algo_id` VARCHAR(10) NOT NULL,
  `algo_type` VARCHAR(10) NOT NULL,
  `provider` VARCHAR(45) NOT NULL,
  `active` CHAR NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`id`));
  
  CREATE TABLE `loyal`.`algo_games` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `algo_id` VARCHAR(10) NOT NULL,
  `algo_type` VARCHAR(10) NOT NULL,
  `game` VARCHAR(45) NOT NULL,
  `active` CHAR NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`id`));

 create table `loyal`.`algorithm`(
        `id` INT not null auto_increment,
       `param_table` VARCHAR(100),
       `description` VARCHAR(100),
        primary key (`id`)
    );

 create table `loyal`.`badge_loyalgift`(
        `id` INT not null auto_increment,
       `badge_id` INT not null,
       `loyal_gift_id` INT not null,
        primary key (`id`)
    );

create index `loyal_gift_id` on `loyal`.`badge_loyalgift`(`loyal_gift_id`);

create index `badge_id` on `loyal`.`badge_loyalgift`(`badge_id`);

 create table `loyal`.`level`(
        `id` INT not null auto_increment,
       `description_en` VARCHAR(100),
       `description_sv` VARCHAR(100),
       `points` INT,
       `image` VARCHAR(100),
        primary key (`id`)
    );

create table `loyal`.`level_gift`(
        `id` INT not null auto_increment,
       `level_id` INT not null,
       `gift_id` INT not null,
        primary key (`id`)
    );

create table `loyal`.`loyalpoints`(
        `id` INT not null auto_increment,
       `bet` INT,
       `currency` VARCHAR(20),
       `points` INT,
        primary key (`id`)
    );

 create table `loyal`.`loyal_gifts`(
        `id` INT not null auto_increment,
       `gift_type` VARCHAR(2),
       `name` VARCHAR(100),
       `description` VARCHAR(100),
       `points` INT,
       `image` VARCHAR(100),
        primary key (`id`)
    );

create table `loyal`.`players_level`(
        `id` INT not null auto_increment,
       `player_id` INT not null,
       `level_id` INT not null,
       `created_by` VARCHAR(20),
       `created_timestamp` DATE,
       `updated_by` VARCHAR(20),
       `updated_timestamp` DATE,
        primary key (`id`)
    );

create table `loyal`.`players_loyalpoints`(
        `id` INT not null auto_increment,
       `player_id` INT not null,
       `loyalpoints_id` INT not null,
       `created_by` VARCHAR(20),
       `created_timestamp` DATE,
       `updated_by` VARCHAR(20),
       `updated_timestamp` DATE,
        primary key (`id`)
    );

create table `loyal`.`players`(
        `id` INT not null auto_increment,
       `active` BIT,
       `external_user_id` VARCHAR(20) not null,
       `bet_amt` INT,
       `loyalpoints_eligibile` BIT,
       `badges_eligible` BIT,
       `age` INT,
       `sex` VARCHAR(1),
       `country` VARCHAR(25),
        primary key (`id`)
    );

create table `loyal`.`provider`(
        `id` INT not null auto_increment,
       `name` VARCHAR(100),
       `description` VARCHAR(100),
       `type` VARCHAR(100),
       `active` BIT,
        primary key (`id`)
    );


create table `loyal`.`players_badge`(
        `id` INT not null auto_increment,
       `player_id` INT not null,
       `badge_id` INT not null,
       `created_by` VARCHAR(20),
       `created_timestamp` DATE,
       `updated_by` VARCHAR(20),
       `updated_timestamp` DATE,
        primary key (`id`)
    );

alter table `loyal`.`players_loyalpoints`
        add constraint FK_players_loyalpoints_points
      FOREIGN KEY (loyalpoints_id) REFERENCES loyalpoints(id)
      ON UPDATE CASCADE 
      ON DELETE CASCADE,
      
        add constraint FK_players_loyalpoints_players
      FOREIGN KEY (player_id) REFERENCES players(id)
      ON UPDATE CASCADE 
      ON DELETE RESTRICT
    ;

alter table `loyal`.`players_level`
        add constraint FK_players_loyalpoints_points
      FOREIGN KEY (level_id) REFERENCES loyalpoints(id)
      ON UPDATE CASCADE 
      ON DELETE CASCADE,
      
        add constraint FK_players_loyalpoints_players
      FOREIGN KEY (player_id) REFERENCES players(id)
      ON UPDATE CASCADE 
      ON DELETE RESTRICT
    ;

alter table `loyal`.`players_badge`
        add constraint FK_players_badge_badge
      FOREIGN KEY (badge_id) REFERENCES badge(id)
      ON UPDATE CASCADE 
      ON DELETE CASCADE,
      
        add constraint FK_players_badge_player
      FOREIGN KEY (player_id) REFERENCES players(id)
      ON UPDATE CASCADE 
      ON DELETE RESTRICT
    ;
  
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
