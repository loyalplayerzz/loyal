    create table `mysql`.`ALGORITHM`(
        `id` INT not null auto_increment,
       `param_table` VARCHAR(100),
       `description` VARCHAR(100),
        primary key (`id`)
    );
    
    
     create table `mysql`.`ALGO_TOTALBETONPROVIDER`(
        `id` INT not null auto_increment,
       `provider_id` VARCHAR(100),
       `bet_amt` INT,
       `no_of_days` INT,
        primary key (`id`)
    );
    
        create table `mysql`.`ALGO_TOTALROUNDSONGAME`(
        `badge_id` INT not null,
       `provider_name` INT,
       `no_of_rounds` INT,
       `name_of_games` VARCHAR(100),
        primary key (`badge_id`)
    );
    
     create table `mysql`.`BADGE_DETAILS`(
        `id` INT not null auto_increment,
       `badge_name` VARCHAR(15),
       `badge_description` VARCHAR(100),
       `description` VARCHAR(100),
       `algo_id` INT,
       `active` BIT,
       `image` VARCHAR(100),
        primary key (`id`)
    );
    
    create table `mysql`.`BADGE_LOYALGIFT`(
        `id` INT not null auto_increment,
       `badge_id` INT not null,
       `loyal_gift_id` INT not null,
        primary key (`id`)
    );
    
     create table `mysql`.`GAME_ROUND_SUMMARY`(
        `id` INT not null auto_increment,
       `player_id` VARCHAR(45) not null,
       `provider` VARCHAR(45),
       `gameId` VARCHAR(45) not null,
       `game_round_date` DATETIME not null,
       `game_rounds` INT not null,
       `total_bet` DOUBLE,
       `total_win` DOUBLE,
        primary key (`id`)
    );
    
     create table `mysql`.`LEVEL_GIFT`(
        `id` INT not null auto_increment,
       `level_id` INT not null,
       `gift_id` INT not null,
        primary key (`id`)
    );
    
     create table `mysql`.`LEVEL`(
        `id` INT not null auto_increment,
       `description_en` VARCHAR(100),
       `description_sv` VARCHAR(100),
       `points` INT,
       `image` VARCHAR(100),
        primary key (`id`)
    );
    
    
    create table `mysql`.`LOYALPOINTS`(
        `id` INT not null auto_increment,
       `bet` INT,
       `currency` VARCHAR(20),
       `points` INT,
        primary key (`id`)
    );
    
      create table `mysql`.`LOYAL_GIFTS`(
        `id` INT not null auto_increment,
       `gift_type` VARCHAR(2),
       `name` VARCHAR(100),
       `description` VARCHAR(100),
       `points` INT,
       `image` VARCHAR(100),
        primary key (`id`)
    );
    
     create table `mysql`.`PLAYERS_BADGE`(
        `id` INT not null auto_increment,
       `player_id` INT not null,
       `badge_id` INT not null,
       `created_by` VARCHAR(20),
       `created_timestamp` DATE,
       `updated_by` VARCHAR(20),
       `updated_timestamp` DATE,
        primary key (`id`)
    );
    
    create table `mysql`.`PLAYERS_LEVEL`(
        `id` INT not null auto_increment,
       `player_id` INT not null,
       `level_id` INT not null,
       `created_by` VARCHAR(20),
       `created_timestamp` DATE,
       `updated_by` VARCHAR(20),
       `updated_timestamp` DATE,
        primary key (`id`)
    );
    
     create table `mysql`.`PLAYERS_LOYALPOINTS`(
        `id` INT not null auto_increment,
       `player_id` INT not null,
       `loyalpoints_id` INT not null,
       `created_by` VARCHAR(20),
       `created_timestamp` DATE,
       `updated_by` VARCHAR(20),
       `updated_timestamp` DATE,
        primary key (`id`)
    );
    
     create table `mysql`.`PLAYERS`(
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
    
     create table `mysql`.`PROVIDER`(
        `id` INT not null auto_increment,
       `name` VARCHAR(100),
       `description` VARCHAR(100),
       `type` VARCHAR(100),
       `active` BIT,
        primary key (`id`)
    );