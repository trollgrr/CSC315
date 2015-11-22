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
Departure_ICAO VARCHAR(4),
Destination_ICAO VARCHAR(4),
DepartureTimeLocal TIME,
ArrivalTimeLocal TIME,
_Tail VARCHAR(6),
Carrier_ID VARCHAR(2),
Flight_No INT(4) UNSIGNED NOT NULL,
PRIMARY KEY (Carrier_ID, Flight_No, Departure_ICAO)
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
Carrier_ID VARCHAR(2) NOT NULL,
FlightNo INT(4) UNSIGNED NOT NULL,
PRIMARY KEY (Carrier_ID, FlightNo)
);

DROP TABLE IF EXISTS carrier;
CREATE TABLE carrier(
CarrierName VARCHAR(45),
CarrierID VARCHAR(3),
Mailing_Address INT(12) UNSIGNED,
PRIMARY KEY(CarrierID)
);

DROP TABLE IF EXISTS carrierOffice;
CREATE TABLE carrierOffice(
Mailing_Address INT(12) UNSIGNED,
PRIMARY KEY (Mailing_Address),
OfficePhone VARCHAR(17)
);

CREATE TABLE flight(
Carrier_ID VARCHAR(2) NOT NULL,
FlightNo INT(4) UNSIGNED NOT NULL,
PRIMARY KEY (Carrier_ID, FlightNo)
);


CREATE TABLE aircraft(
Tail VARCHAR(6),
PRIMARY KEY (Tail),
acftMake VARCHAR(45),
acftModel VARCHAR(45),
classCapFirst INT(4) UNSIGNED NOT NULL,
classCapSecond INT(4) UNSIGNED NOT NULL,
classCapThird INT(4) UNSIGNED NOT NULL
);

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
Customer_ID INT(12) UNSIGNED
);

DROP TABLE IF EXISTS charge;
CREATE TABLE charge(
Created DATETIME,
AmtRcvd NUMERIC(10,2),
AmtPaid NUMERIC(10,2),
Payment_ID INT(12) UNSIGNED NOT NULL,
PRIMARY KEY (Created, Payment_ID)
);

ALTER TABLE customer ADD FOREIGN KEY (Physical_Address) REFERENCES address (AddressID);
ALTER TABLE customer ADD FOREIGN KEY (Mailing_Address) REFERENCES address (AddressID);
ALTER TABLE airport ADD FOREIGN KEY (Mailing_Address) REFERENCES address (AddressID);
ALTER TABLE carrier ADD FOREIGN KEY (Mailing_Address) REFERENCES address (AddressID);
ALTER TABLE carrierOffice ADD FOREIGN KEY (Mailing_Address) REFERENCES address (AddressID);
ALTER TABLE reservation ADD FOREIGN KEY (Customer_ID) REFERENCES customer (CustomerID);
ALTER TABLE flightleg ADD FOREIGN KEY (Departure_ICAO) REFERENCES airport (ICAO);
ALTER TABLE flightleg ADD FOREIGN KEY (Destination_ICAO) REFERENCES airport (ICAO);
ALTER TABLE flightleg ADD FOREIGN KEY (_Tail) REFERENCES aircraft (Tail);
ALTER TABLE flightleg ADD FOREIGN KEY (Carrier_ID) REFERENCES carrier (CarrierID);
ALTER TABLE flightleg ADD FOREIGN KEY (Flight_No) REFERENCES flight (FlightNo);
ALTER TABLE charge ADD FOREIGN KEY (Payment_ID) REFERENCES paymentType (PaymentID);

