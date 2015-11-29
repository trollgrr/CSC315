DROP DATABASE if exists FlightHandler;
CREATE DATABASE FlightHandler;
FLUSH PRIVILEGES;
USE FlightHandler;
DROP TABLE IF EXISTS reservation;
CREATE TABLE reservation(
ReservationID INT(12) UNSIGNED NOT NULL AUTO_INCREMENT,
Customer_ID INT(12) UNSIGNED,
PRIMARY KEY(ReservationID),
ReservationHold BOOL NOT NULL,
Flight_No INT(4) UNSIGNED NOT NULL,
Carrier_ID VARCHAR(2) NOT NULL,
Departure_Date DATE NOT NULL,
INDEX (ReservationID));
DROP TABLE IF EXISTS customer;
CREATE TABLE customer(
CustomerID INT(12) UNSIGNED NOT NULL AUTO_INCREMENT,
PRIMARY KEY(CustomerID),
FirstName VARCHAR(45) NOT NULL,
LastName VARCHAR(45) NOT NULL,
HomePhone VARCHAR(17),
PrimaryCardNo VARCHAR(45),
Mailing_Address INT(12) UNSIGNED,
Physical_Address INT(12) UNSIGNED,
SeatPref VARCHAR(5), #AISLE CNTR DOOR WSHC
MealPref VARCHAR(5), #VEGGI HALAL KOSHR PASTA NOPRF
AcftPosPref VARCHAR(3)); #FRT WNG TAL
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
Country VARCHAR(4));
DROP TABLE IF EXISTS flight;
CREATE TABLE flight(
LegStatus BOOL,
Departure_IATA VARCHAR(3),
Destination_IATA VARCHAR(3),
DepartureTimeLocal TIME,
DepartureDate DATE NOT NULL,
ArrivalTimeLocal TIME,
_Tail VARCHAR(6),
Carrier_ID VARCHAR(2) NOT NULL,
FlightNo INT(4) UNSIGNED NOT NULL,
CostThirdClass DECIMAL(10,2),
CostSecondClass DECIMAL(10,2),
CostFirstClass DECIMAL(10,2),
PRIMARY KEY (Carrier_ID, FlightNo, DepartureDate));
DROP TABLE IF EXISTS airport;
CREATE TABLE airport(
ICAO VARCHAR(4),
IATA VARCHAR(3),
PRIMARY KEY(IATA),
Mailing_Address INT(12) UNSIGNED,
FullName VARCHAR(45),
Phone VARCHAR(17));
DROP TABLE IF EXISTS carrier;
CREATE TABLE carrier(
CarrierName VARCHAR(45),
CarrierID VARCHAR(2),
Mailing_Address INT(12) UNSIGNED,
PRIMARY KEY(CarrierID));
DROP TABLE IF EXISTS carrierOffice;
CREATE TABLE carrierOffice(
Mailing_Address INT(12) UNSIGNED,
PRIMARY KEY (Mailing_Address),
OfficePhone VARCHAR(17));
CREATE TABLE aircraft(
Tail VARCHAR(6),
PRIMARY KEY (Tail),
acftMake VARCHAR(45),
acftModel VARCHAR(45),
classCapFirst INT(4) UNSIGNED NOT NULL,
classCapSecond INT(4) UNSIGNED NOT NULL,
classCapThird INT(4) UNSIGNED NOT NULL);
DROP TABLE IF EXISTS paymentType;
CREATE TABLE paymentType(
Method VARCHAR(45),
PaymentID INT(12) UNSIGNED NOT NULL AUTO_INCREMENT,
PRIMARY KEY (PaymentID),
CardNo INT(16) UNSIGNED,
ExpirationDate DATE,
SecurityCode INT(4) UNSIGNED,
AccountNo INT(17) UNSIGNED,
RoutingNo INT(17) UNSIGNED,
CardName VARCHAR(45),
IBAN VARCHAR (16),
Customer_ID INT(12) UNSIGNED);
DROP TABLE IF EXISTS charge;
CREATE TABLE charge(
Created DATETIME,
AmtRcvd NUMERIC(10,2),
AmtPaid NUMERIC(10,2),
Payment_ID INT(12) UNSIGNED NOT NULL,
PRIMARY KEY (Created, Payment_ID));
DROP TABLE IF EXISTS frequentFlierGroup;
CREATE TABLE frequentFlierGroup(
CustomerID INT(12) UNSIGNED NOT NULL,
FFGroupID INT(12) UNSIGNED NOT NULL,
MembershipName VARCHAR(50) NOT NULL,
PRIMARY KEY (FFGroupID));
DROP TABLE IF EXISTS frequentFlierMembership;
CREATE TABLE frequentFlierMemberShip(
FFGroupID INT(12) UNSIGNED NOT NULL,
MembershipName VARCHAR(50) NOT NULL,
FFPoints INT(12) UNSIGNED,
PRIMARY KEY(FFGroupID, MembershipName),
FOREIGN KEY (FFGroupID) REFERENCES frequentFlierGroup(FFGroupID));
ALTER TABLE customer ADD FOREIGN KEY (Physical_Address) REFERENCES address (AddressID);
ALTER TABLE customer ADD FOREIGN KEY (Mailing_Address) REFERENCES address (AddressID);
ALTER TABLE airport ADD FOREIGN KEY (Mailing_Address) REFERENCES address (AddressID);
ALTER TABLE carrier ADD FOREIGN KEY (Mailing_Address) REFERENCES address (AddressID);
ALTER TABLE carrierOffice ADD FOREIGN KEY (Mailing_Address) REFERENCES address (AddressID);
ALTER TABLE reservation ADD FOREIGN KEY (Customer_ID) REFERENCES customer (CustomerID);
ALTER TABLE flight ADD FOREIGN KEY (Departure_IATA) REFERENCES airport (IATA);
ALTER TABLE flight ADD FOREIGN KEY (Destination_IATA) REFERENCES airport (IATA);
ALTER TABLE flight ADD FOREIGN KEY (_Tail) REFERENCES aircraft (Tail);
ALTER TABLE flight ADD FOREIGN KEY (Carrier_ID) REFERENCES carrier (CarrierID);
ALTER TABLE charge ADD FOREIGN KEY (Payment_ID) REFERENCES paymentType (PaymentID);
ALTER TABLE reservation ADD FOREIGN KEY (Flight_No) REFERENCES flight (FlightNo);
ALTER TABLE reservation ADD FOREIGN KEY (Carrier_ID) REFERENCES carrier (CarrierID);
ALTER TABLE reservation ADD FOREIGN KEY (Departure_Date) REFERENCES flight (DepartureDate);

