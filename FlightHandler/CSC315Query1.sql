USE FlightHandler;
SELECT Carrier_ID, FlightNo, Departure_IATA, Destination_IATA FROM flight;
SELECT Carrier_ID, FlightNo, DepartureTimeLocal, ArrivalTimeLocal FROM flight WHERE Departure_IATA='DFW' AND Destination_IATA='LAX' AND DepartureDate='2006-12-31';
SELECT CarrierName