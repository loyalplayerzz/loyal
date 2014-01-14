CREATE TABLE `game_round_master` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `gameId` varchar(45) NOT NULL,
  `game_round_id` varchar(45) NOT NULL,
  `transaction_type` varchar(45) NOT NULL,
  `game_round_start_date` datetime NOT NULL,
  `game_round_end_date` datetime DEFAULT NULL,
  `casino_currency_bet` double DEFAULT NULL,
  `casino_currency_win` double DEFAULT NULL,
  `player_id` varchar(45) DEFAULT NULL,
  `analyzed_badges` char(1) DEFAULT 'N',
  `game_provider` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `game_round_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `player_id` varchar(45) NOT NULL,
  `provider` varchar(45) DEFAULT NULL,
  `gameId` varchar(45) NOT NULL,
  `game_round_date` datetime NOT NULL,
  `game_rounds` int(11) NOT NULL,
  `total_bet` double DEFAULT NULL,
  `total_win` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `my_key` (`player_id`,`gameId`,`game_round_date`)
);

ALTER TABLE loyal.game_round_summary ADD UNIQUE KEY round_summary_unique_key ( player_id, gameId, game_round_date);

CREATE TABLE `job_audit_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jobId` varchar(45) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `row_id_start` varchar(10) DEFAULT NULL,
  `row_id_end` varchar(10) DEFAULT NULL,
  `job_type` varchar(10) DEFAULT NULL,
  `job_status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `player_badge_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `player_id` varchar(45) NOT NULL,
  `badge_id` varchar(45) NOT NULL,
  `active` char(1) NOT NULL DEFAULT 'Y',
  `badge_date` datetime NOT NULL,
  `row_id` int(10) DEFAULT NULL,
  `badge_type` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
);

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
 --  ------------------------------------------------------------------------------
-- We have to check if we are using following tables or not. At leasrt we are 
-- we are not using it for badges.

--  ------------------------------------------------------------------------------- 
  CREATE TABLE `loyal`.`algorithm_master`(
	`id` INT not null auto_increment,
	`param_table` VARCHAR(100),
	`description` VARCHAR(250),
	primary key (`id`)
	);
	
   create table `loyal`.`badge_loyal_gift`(
    `id` INT not null auto_increment,
    `badge_id` INT not null,
    `loyal_gift_id` INT not null,
     primary key (`id`)
    );
	
	create table `loyal`.`level_gift`(
        `id` INT not null auto_increment,
       `level_id` INT not null,
       `gift_id` INT not null,
        primary key (`id`)
    );
	
	create table `loyal`.`level_master`(
       `id` INT not null auto_increment,
       `description` VARCHAR(100),
       `level_points` INT,
       `image` VARCHAR(100),
        primary key (`id`)
    );
	
	create table `loyal`.`loyal_points`(
        `id` INT not null auto_increment,
       `bet_amount` double,
       `currency` VARCHAR(10),
       `loyal_points` INT,
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
       `created_timestamp` datetime,
       `updated_by` VARCHAR(20),
       `updated_timestamp` datetime,
        primary key (`id`)
    );
    
     create table `loyal`.`players_loyalpoints`(
        `id` INT not null auto_increment,
       `player_id` INT not null,
       `loyalpoints_id` INT not null,
       `created_by` VARCHAR(20),
       `created_timestamp` datetime,
       `updated_by` VARCHAR(20),
       `updated_timestamp` datetime,
        primary key (`id`)
    );
    
     create table `loyal`.`players_master`(
        `id` INT not null auto_increment,
       `active` BIT,
       `external_user_id` VARCHAR(20) not null,
       `bet_amt` double,
       `loyalpoints_eligibile` BIT,
       `badges_eligible` BIT,
       `date_of_birth` datetime,
       `sex` VARCHAR(1),
       `country` VARCHAR(25),
        primary key (`id`)
    );
    
     create table `loyal`.`providers_master`(
        `id` INT not null auto_increment,
       `provider_name` VARCHAR(100),
       `description` VARCHAR(250),
       `type` VARCHAR(10),
       `active` BIT,
        primary key (`id`)
    );
    
    create table `loyal`.`loyalpoints_master`(
        `id` INT not null auto_increment,
       `bet` INT,
       `currency` VARCHAR(20),
       `points` INT,
        primary key (`id`)
    );
    
    CREATE TABLE `loyal`.`jobs_details` (
	  `id` INT NOT NULL AUTO_INCREMENT,
	  `job_name` VARCHAR(45) NOT NULL,
	  `active` CHAR NOT NULL DEFAULT 'Y',
	  PRIMARY KEY (`id`)
	);
	
    
alter table `loyal`.`players_loyalpoints`
        add constraint FK_players_loyalpoints_points
      FOREIGN KEY (loyalpoints_id) REFERENCES loyalpoints_master(id)
      ON UPDATE CASCADE 
      ON DELETE CASCADE,
      
        add constraint FK_players_loyalpoints_players
      FOREIGN KEY (player_id) REFERENCES players_master(id)
      ON UPDATE CASCADE 
      ON DELETE RESTRICT
    ;

alter table `loyal`.`players_level`
        add constraint FK_players_level_levels
      FOREIGN KEY (level_id) REFERENCES level_master(id)
      ON UPDATE CASCADE 
      ON DELETE CASCADE,
      
        add constraint FK_players_level_players
      FOREIGN KEY (player_id) REFERENCES players_master(id)
      ON UPDATE CASCADE 
      ON DELETE RESTRICT
    ;

alter table `loyal`.`players_badge`
        add constraint FK_players_badge_badge
      FOREIGN KEY (badge_id) REFERENCES badge_details(id)
      ON UPDATE CASCADE 
      ON DELETE CASCADE,
      
        add constraint FK_players_badge_player
      FOREIGN KEY (player_id) REFERENCES players_master(id)
      ON UPDATE CASCADE 
      ON DELETE RESTRICT
    ;

  -- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `analyze_game_round`()
BEGIN
DECLARE lastSuccessRow INT;
DECLARE lastAnalyzedRowId INT;
DECLARE newAuditId INT;
select IFNULL(MAX(row_id_end), 0) row_id_end into lastSuccessRow from job_audit_details where jobId='MASTER' && job_status='SUCCESS';
select IFNULL(MAX(ID), 0) id into lastAnalyzedRowId from game_round_master where id between  lastSuccessRow and lastSuccessRow+20000;
if(lastAnalyzedRowId > lastSuccessRow) THEN 
INSERT INTO job_audit_details (jobId, start_date, row_id_start, job_type,job_status) values ('MASTER', now(), lastSuccessRow+1, 'MASTER', 'START');
set newAuditId = last_insert_id();
select concat ('test ',newAuditId);
INSERT INTO game_round_summary (player_id, game_round_date, total_bet, total_win,provider,gameId, game_rounds) 
select player_id
	,date(game_round_end_date)
	,sum(casino_currency_bet) as totbet
	,sum(casino_currency_win) as totwin
	,game_provider
	,gameId
	,count(1) gamerounds
from game_round_master where id > lastSuccessRow and id <= lastAnalyzedRowId
group by player_id
	,date(game_round_end_date)
ON DUPLICATE KEY UPDATE game_rounds= game_rounds+VALUES(game_rounds), total_bet=total_bet+VALUES(total_bet), total_win=total_win+VALUES(total_win);
UPDATE job_audit_details set end_date = now(), row_id_end = lastAnalyzedRowId, job_status='SUCCESS' where id = newAuditId;
END IF;
END