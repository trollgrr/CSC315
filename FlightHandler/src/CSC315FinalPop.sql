INSERT INTO address VALUES ('', '', '', '1060 W Addison St', 'Chicago', 'IL', '', '60613', 'USA');
INSERT INTO address VALUES ('', '', '', 'International Pkwy', 'DFW Airport', 'TX', '', '75261', 'USA');
INSERT INTO address VALUES ('', '', '', '1 World Way', 'Los Angeles', 'CA', '', '90045', 'USA');
INSERT INTO address VALUES ('', '', '', '2719 East College Avenue', 'Decatur', 'GA', '', '30030', 'USA');
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
INSERT INTO customer VALUES ('', 'Elwood', 'Blues', '867-5309', 'XXXX XXXX XXXX XXXX','1', '2', 'NOPRF', 'HALAL', 'WNG');
INSERT INTO customer VALUES ('', 'Gilbert', 'Gottfried', '867-5309', 'XXXX XXXX XXXX XXXX','2', '3', 'NOPRF', 'HALAL', 'FRT');
INSERT INTO customer VALUES ('', 'Jake', 'Blues', '867-5309', 'XXXX XXXX XXXX XXXX','3', '2', 'NOPRF', 'FRIED', 'MID');
INSERT INTO customer VALUES ('', 'Ann', 'Risley', '867-5309', 'XXXX XXXX XXXX XXXX','4', '3', 'NOPRF', 'VEGGI', 'WNG');
INSERT INTO customer VALUES ('', 'Charles', 'Rocket', '867-5309', 'XXXX XXXX XXXX XXXX','4', '4', 'NOPRF', 'VEGGI', 'BCK');
INSERT INTO customer VALUES ('', 'Yvonne', 'Hudson', '867-5309', 'XXXX XXXX XXXX XXXX','1', '2', 'NOPRF', 'VEGGI', 'BCK');
INSERT INTO customer VALUES ('', 'Eddie', 'Murphy', '867-5309', 'XXXX XXXX XXXX XXXX','2', '3', 'NOPRF', 'VEGGI', 'FRT');
INSERT INTO customer VALUES ('', 'Joe', 'Piscopo', '867-5309', 'XXXX XXXX XXXX XXXX','3', '4', 'NOPRF', 'VEGGI', 'FRT');
INSERT INTO aircraft VALUES ('N865PA', 'Boeing', '747', '100', '100', '210');
INSERT INTO aircraft VALUES ('N499PA', 'Boeing', '747', '100', '100', '210');
INSERT INTO aircraft VALUES ('N342PA', 'Boeing', '747', '100', '100', '210');
INSERT INTO aircraft VALUES ('N998PA', 'Boeing', '747', '100', '100', '210');
INSERT INTO aircraft VALUES ('N7191PA', 'Boeing', '747', '100', '100', '210');
INSERT INTO aircraft VALUES ('N807PA', 'Boeing', '747', '100', '100', '210');
INSERT INTO aircraft VALUES ('N736PA', 'Boeing', '747', '100', '100', '210');
INSERT INTO flight VALUES ('false', 'TRF', 'AYT', '131500', '20150113', '141500', 'N865PA', 'DH', '4500', '100', '200', '1300');
INSERT INTO flight VALUES ('false', 'DFW', 'LAX', '111500', '20061231', '131500', 'N499PA', 'DL', '2300', '200', '400', '2300');
INSERT INTO flight VALUES ('false', 'DFW', 'LAX', '061500', '20061231', '081500', 'N998PA', 'EA', '9345', '900', '1800', '3100');
INSERT INTO flight VALUES ('false', 'DFW', 'LAX', '211500', '20061231', '231500', 'N499PA', 'DH', '9435', '200', '400', '3400');
INSERT INTO flight VALUES ('false', 'DFW', 'LAX', '081500', '20061231', '101500', 'N7191PA', 'DL', '9875', '400', '450', '3600');
INSERT INTO flight VALUES ('false', 'DFW', 'LAX', '121500', '20061231', '141500', 'N807PA', 'WN', '8795', '300', '500', '3400');
INSERT INTO flight VALUES ('false', 'DFW', 'LAX', '131500', '20061231', '151500', 'N736PA', 'EA', '1250', '600', '800', '1600');
INSERT INTO reservation VALUES ('', '1', 'false', '4500', 'DH', '20150113');
INSERT INTO reservation VALUES ('', '2', 'false', '2300', 'DL', '20061231');
INSERT INTO reservation VALUES ('', '3', 'false', '2300', 'DL', '20061231');
INSERT INTO reservation VALUES ('', '4', 'false', '9345', 'EA', '20061231');
INSERT INTO reservation VALUES ('', '5', 'false', '9435', 'DH', '20061231');
INSERT INTO reservation VALUES ('', '6', 'false', '9875', 'DL', '20061231');
