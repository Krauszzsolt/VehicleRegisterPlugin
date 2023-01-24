package org.example.vehicle.register.plugin;

import org.example.app.VehicleRegister;
import org.example.app.interfaces.Presenter;
import org.example.toll.system.app.entities.Vehicle;
import org.example.toll.system.app.plugin.VehiclePlugin;
import org.example.vehicle.register.plugin.parser.VehicleParser;
import org.example.vehicle.register.plugin.validator.VehicleValidator;


public class VehicleRegisterPlugin implements Presenter, VehiclePlugin {

    private VehicleValidator vehicleValidator = new VehicleValidator();
    private VehicleParser vehicleParser = new VehicleParser();

    private VehicleRegister vehicleRegister;
    private Vehicle vehicle;

    public void setVehicleRegister(VehicleRegister vehicleRegister) {
        this.vehicleRegister = vehicleRegister;
    }


    @Override
    public void DisplayVehicle(String data) {
        vehicleValidator.validateString(data);
        vehicle = vehicleParser.StringToEntity(data);
    }

    @Override
    public void DisplaySuccess() {

    }

    @Override
    public void DisplayError() {

    }

    @Override
    public Vehicle getVehicleByRegistrationNumber(String registrationNumber) {
        //ToJSON
        String r = vehicleParser.RegistrationNumberToJson(registrationNumber);
        vehicleRegister.loadVehicle(r);
        return vehicle;
    }
}
