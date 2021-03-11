CREATE DATABASE IF NOT EXISTS deviseDB ;
use deviseDB;

DROP TABLE IF EXISTS devise;


######################## CREATE  TABLE ########################################

CREATE TABLE devise(
	code VARCHAR(8),
	monnaie VARCHAR(64),
	d_change double,
	
	PRIMARY KEY(code));	

#########################  INSERT INTO   #####################################

INSERT INTO devise (code,d_change,monnaie) VALUES ('EUR',1,'euro');
INSERT INTO devise (code,d_change,monnaie) VALUES ('JPY',123.8,'yen');
INSERT INTO devise (code,d_change,monnaie) VALUES ('USD',1.1,'dollar');
INSERT INTO devise (code,d_change,monnaie) VALUES ('GBP',0.9,'livre');

####### VERIF ######

show tables;
SELECT * FROM devise;
