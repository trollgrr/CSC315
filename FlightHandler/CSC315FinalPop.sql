USE FlightHandler;
INSERT INTO address VALUES (NULL, NULL, NULL, '1060 W Addison St', 'Chicago', 'IL', '', '60613', 'USA');
INSERT INTO address VALUES (NULL, NULL, NULL, 'International Pkwy', 'DFW Airport', 'TX', '', '75261', 'USA');
INSERT INTO address VALUES (NULL, NULL, NULL, '1 World Way', 'Los Angeles', 'CA', '', '90045', 'USA');
INSERT INTO address VALUES (NULL, NULL, NULL, '2719 East College Avenue', 'Decatur', 'GA', '', '30030', 'USA');
INSERT INTO airport VALUES ('ENTO', 'TRF', '1', 'Torp – Sandefjord, Vestfold','4733427000');
INSERT INTO airport VALUES ('LTAI', 'AYT', '1', 'Antalya International Airport','902424447423');
INSERT INTO airport VALUES ('KDFW', 'DFW', '2', 'Dallas/Fort Worth International Airport','9729733112');
INSERT INTO airport VALUES ('KLAX', 'LAX', '3', 'Los Angeles International Airport','8554635252');
INSERT INTO carrier VALUES ('Norwegian Air Norway', 'DH', '1');
INSERT INTO carrier VALUES ('Delta', 'DL', '2');
INSERT INTO carrier VALUES ('Southwest', 'WN', '3');
INSERT INTO carrier VALUES ('Eastern Air Lines Group Inc.', 'EA', '4');
INSERT INTO carrierOffice VALUES ('1', '47815 21 815');
INSERT INTO carrierOffice VALUES ('2', '8675309');
INSERT INTO customer VALUES (NULL, 'Elwood', 'Blues', '867-5309', '5309 5309 5309 5309','1', '2', 'NOPRF', 'HALAL', 'WNG');
INSERT INTO customer VALUES (NULL, 'Gilbert', 'Gottfried', '867-5309', '08675 08675 08675 08675','2', '3', 'NOPRF', 'HALAL', 'FRT');
INSERT INTO customer VALUES (NULL, 'Jake', 'Blues', '867-5309', '5309 08675 5309 08675','3', '2', 'NOPRF', 'FRIED', 'MID');
INSERT INTO customer VALUES (NULL, 'Ann', 'Risley', '867-5309', '08675 5309 08675 5309','4', '3', 'NOPRF', 'VEGGI', 'WNG');
INSERT INTO customer VALUES (NULL, 'Charles', 'Rocket', '867-5309', '5309 08675 5309 08675','4', '4', 'NOPRF', 'VEGGI', 'BCK');
INSERT INTO customer VALUES (NULL, 'Yvonne', 'Hudson', '867-5309', '08675 5309 08675 5309','1', '2', 'NOPRF', 'VEGGI', 'BCK');
INSERT INTO customer VALUES (NULL, 'Eddie', 'Murphy', '867-5309', '5309 08675 5309 08675','2', '3', 'NOPRF', 'VEGGI', 'FRT');
INSERT INTO customer VALUES (NULL, 'Bill', 'Jones', '867-5109', '08675 5309 08675 5309','4', '1', 'NOPRF', 'NOPRF', 'FRT');
INSERT INTO customer VALUES (NULL, 'Ted', 'Pupp', '867-5309', '8875 5309 08675 5309','2', '3', 'NOPRF', 'VEGGI', 'FRT');
INSERT INTO customer VALUES (NULL, 'Fisty', 'Cuffs', '867-5309', '4575 5309 08675 5309','3', '1', 'NOPRF', 'VEGGI', 'FRT');
INSERT INTO customer VALUES (NULL, 'Jose', 'Alvarez', '867-5309', '2675 5309 08675 5309','3', '2', 'NOPRF', 'VEGGI', 'BCK');
INSERT INTO customer VALUES (NULL, 'Johnny', 'Bravo', '867-5309', '3675 5309 08675 5309','2', '3', 'NOPRF', 'VEGGI', 'FRT');
INSERT INTO customer VALUES (NULL, 'Chad', 'Stanfield', '867-5309', '9675 5309 08675 5309','3', '4', 'NOPRF', 'FRIED', 'FRT');
INSERT INTO customer VALUES (NULL, 'Austin', 'Bloomberg', '867-5309', '1675 5309 08675 5309','1', '2', 'NOPRF', 'VEGGI', 'FRT');
INSERT INTO customer VALUES (NULL, 'Timothy', 'Stevens', '867-5309', '6445 5309 08675 5309','1', '2', 'NOPRF', 'NOPRF', 'FRT');
INSERT INTO customer VALUES (NULL, 'Alfred', 'Jones', '867-5309', '4445 5309 08675 5309','3', '4', 'NOPRF', 'VEGGI', 'FRT');
INSERT INTO customer VALUES (NULL, 'Bill', 'Smith', '867-5309', '7875 5309 08675 5309','3', '2', 'NOPRF', 'VEGGI', 'FRT');
INSERT INTO customer VALUES (NULL, 'Jennifer', 'Sanchez', '867-5309', '7775 5309 08675 5309','3', '1', 'NOPRF', 'VEGGI', 'FRT');
INSERT INTO aircraft VALUES ('N865PA', 'Boeing', '747', '100', '100', '210');
INSERT INTO aircraft VALUES ('N499PA', 'Boeing', '747', '100', '100', '210');
INSERT INTO aircraft VALUES ('N342PA', 'Boeing', '747', '100', '100', '210');
INSERT INTO aircraft VALUES ('N998PA', 'Boeing', '747', '100', '100', '210');
INSERT INTO aircraft VALUES ('N719PA', 'Boeing', '747', '100', '100', '210');
INSERT INTO aircraft VALUES ('N807PA', 'Boeing', '747', '100', '100', '210');
INSERT INTO aircraft VALUES ('N736PA', 'Boeing', '747', '100', '100', '210');
INSERT INTO flight VALUES ('0', 'TRF', 'AYT', '131500', '20150113', '141500', 'N865PA', 'DH', '4500', '100', '200', '1300');
INSERT INTO flight VALUES ('0', 'DFW', 'LAX', '111500', '20061231', '131500', 'N499PA', 'DL', '2300', '200', '400', '2300');
INSERT INTO flight VALUES ('0', 'DFW', 'LAX', '061500', '20061231', '081500', 'N998PA', 'EA', '9345', '900', '1800', '3100');
INSERT INTO flight VALUES ('0', 'DFW', 'LAX', '211500', '20061231', '231500', 'N499PA', 'DH', '9435', '200', '400', '3400');
INSERT INTO flight VALUES ('0', 'DFW', 'LAX', '081500', '20061231', '101500', 'N719PA', 'DL', '9875', '400', '450', '3600');
INSERT INTO flight VALUES ('0', 'DFW', 'LAX', '121500', '20061231', '141500', 'N807PA', 'WN', '8795', '300', '500', '3400');
INSERT INTO flight VALUES ('0', 'DFW', 'LAX', '131500', '20061231', '151500', 'N736PA', 'EA', '1250', '600', '800', '1600');
INSERT INTO flight VALUES ('0', 'TRF', 'AYT', '131500', '20140113', '141500', 'N865PA', 'DH', '4500', '100', '200', '1300');
INSERT INTO flight VALUES ('0', 'DFW', 'LAX', '111500', '20041231', '131500', 'N499PA', 'DL', '2300', '200', '400', '2300');
INSERT INTO flight VALUES ('0', 'DFW', 'LAX', '061500', '20041231', '081500', 'N998PA', 'EA', '9345', '900', '1800', '3100');
INSERT INTO flight VALUES ('0', 'DFW', 'LAX', '211500', '20041231', '231500', 'N499PA', 'DH', '9435', '200', '400', '3400');
INSERT INTO flight VALUES ('0', 'DFW', 'LAX', '081500', '20041231', '101500', 'N719PA', 'DL', '9875', '400', '450', '3600');
INSERT INTO flight VALUES ('0', 'DFW', 'LAX', '121500', '20041231', '141500', 'N807PA', 'WN', '8795', '300', '500', '3400');
INSERT INTO flight VALUES ('0', 'DFW', 'LAX', '131500', '20041231', '151500', 'N736PA', 'EA', '1250', '600', '800', '1600');
INSERT INTO reservation VALUES (NULL, '1', '0', '4500', 'DH', '20150113', '0','0','1');
INSERT INTO reservation VALUES (NULL, '2', '0', '2300', 'DL', '20061231', '0','0','1');
INSERT INTO reservation VALUES (NULL, '3', '0', '2300', 'DL', '20061231', '0','1','0');
INSERT INTO reservation VALUES (NULL, '4', '0', '9345', 'EA', '20061231', '0','0','1');
INSERT INTO reservation VALUES (NULL, '5', '0', '9435', 'DH', '20061231', '0','0','1');
INSERT INTO reservation VALUES (NULL, '6', '0', '9875', 'DL', '20061231', '1','0','0');
INSERT INTO reservation VALUES (NULL, '1', '0', '4500', 'DH', '20140113', '0','1','0');
INSERT INTO reservation VALUES (NULL, '2', '0', '2300', 'DL', '20041231', '0','0','1');
INSERT INTO reservation VALUES (NULL, '3', '0', '2300', 'DL', '20041231', '0','1','0');
INSERT INTO reservation VALUES (NULL, '4', '0', '9345', 'EA', '20041231', '1','0','0');
INSERT INTO reservation VALUES (NULL, '5', '0', '9435', 'DH', '20041231', '0','1','0');
INSERT INTO reservation VALUES (NULL, '6', '0', '9875', 'DL', '20041231', '1','0','0');
INSERT INTO reservation VALUES (NULL, '7', '0', '9875', 'DL', '20041231', '0','0','1');
INSERT INTO reservation VALUES (NULL, '8', '0', '9875', 'DL', '20041231', '1','0','0');
INSERT INTO reservation VALUES (NULL, '9', '0', '9875', 'DL', '20041231', '1','0','0');
INSERT INTO reservation VALUES (NULL, '10', '0', '9875', 'DL', '20061231', '0','0','1');
INSERT INTO reservation VALUES (NULL, '11', '0', '9875', 'DL', '20041231', '1','0','0');
INSERT INTO reservation VALUES (NULL, '12', '0', '9875', 'DL', '20061231', '0','1','0');
INSERT INTO reservation VALUES (NULL, '13', '0', '9875', 'DL', '20041231', '1','0','0');
INSERT INTO reservation VALUES (NULL, '14', '0', '9875', 'DL', '20061231', '0','1','0');
INSERT INTO reservation VALUES (NULL, '15', '0', '9875', 'DL', '20061231', '1','0','0');
INSERT INTO reservation VALUES (NULL, '16', '0', '9875', 'DL', '20061231', '0','0','1');
INSERT INTO reservation VALUES (NULL, '17', '0', '9875', 'DL', '20061231', '0','0','1');
INSERT INTO reservation VALUES (NULL, '18', '0', '9875', 'DL', '20041231', '0','0','1');

