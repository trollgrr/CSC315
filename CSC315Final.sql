# Declarations to initialize database in MySQL
# mysql -u root -p
DROP DATABASE if exists FlightHandler;
CREATE DATABASE FlightHandler;
#Create user is only necessary in new database
#CREATE USER 'bupton'@'localhost' IDENTIFIED BY 'password';
#CREATE USER 'johnogel'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON CSC315A3.* TO 'bupton'@'localhost';
GRANT ALL PRIVILEGES ON CSC315A3.* TO 'johnogel'@'localhost';
FLUSH PRIVILEGES;
USE FlightHandler;

DROP TABLE IF EXISTS reservation;
CREATE TABLE reservation(
ReservationID INT(12) UNSIGNED NOT NULL AUTO_INCREMENT,
PRIMARY KEY(ReservationID),
ReservationHold BOOL NOT NULL,
INDEX (ReservationID)
);
DROP TABLE IF EXISTS customer;
CREATE TABLE customer(
CustomerID INT(12) UNSIGNED NOT NULL AUTO_INCREMENT,
PRIMARY KEY(CustomerID),
FirstName VARCHAR(45) NOT NULL,
LastName VARCHAR(45) NOT NULL,
HomePhone VARCHAR(17),
PrimaryCardNo VARCHAR(45),
MailingAddress VARCHAR(45),
SeatPref VARCHAR(5), #AISLE CNTR DOOR WSHC
MealPref VARCHAR(5), #VEGGI HALAL KOSHR PASTA NOPRF
AcftPosPref VARCHAR(3), #FRT WNG TAL
FrequentFlierProgA INT(12) UNSIGNED,
FrequentFlierProgB INT(12) UNSIGNED,
FrequentFlierProgC INT(12) UNSIGNED,
FrequentFlierProgD INT(12) UNSIGNED
);

# I like this idea, though we might run slowly with lots multiple queries
# but it might work better with multiple addresses for each customer
DROP TABLE IF EXISTS address;
CREATE TABLE address(
AddressID INT(12) UNSIGNED NOT NULL AUTO_INCREMENT,
PRIMARY KEY(AddressID),
Box INT(5) UNSIGNED,
ApartmentNo VARCHAR(9),
Street VARCHAR(45) NOT NULL,
City VARCHAR(45)NOT NULL,
State VARCHAR(2),
Province VARCHAR(22),
Zip INT (5),
Country VARCHAR(4)
);

DROP TABLE IF EXISTS flightleg;
CREATE TABLE flightleg(
LegStatus BOOL,
DepartureICAO VARCHAR(4),
DestinationICAO VARCHAR(4),
DepartureTimeLocal TIME,
ArrivalTimeLocal TIME
);

DROP TABLE IF EXISTS airport;
CREATE TABLE airport(
ICAO VARCHAR(4),
PRIMARY KEY(ICAO),
IATA VARCHAR(3),
FullName VARCHAR(45),
Phone VARCHAR(17)
);

DROP TABLE IF EXISTS flight;
CREATE TABLE flight(
#CarrierName VARCHAR(45),
FlightNumber INT(4) UNSIGNED
);

DROP TABLE IF EXISTS carrier;
CREATE TABLE carrier(
CarrierName VARCHAR(45),
CarrierID VARCHAR(3),
PRIMARY KEY(CarrierID)
);

DROP TABLE IF EXISTS carrierOffice;
CREATE TABLE carrierOffice(
OfficePhone VARCHAR(17)
);
