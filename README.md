# ParkingLotSim
This parking lot program is designed to simulate a parking lot taking in and processing cars.  The ParkingLot class is the main hub for all of the other objects in the program with the exception of the Parker.  The simulation is ran in the main method of the ParkingLotDemo by generating ten random Car and Parker objects (with random expected parking time) and entering them into the ParkingLot object.  The ParkingLot is designed with the Decorator Pattern, and consists of Level aggregates that take the driver to the following level to park or the previous level to exit after it has completed parking.  The main level is the entrance, which holds TicketMachine and BillingMachine objects to set the Parker with tickets as it enters and exits parking lot.  The ticket machines operate with the parking lot Server which holds data for active tickets and available parking locations.