package org.example;

// AmericanPowerPlug interface
interface AmericanPowerPlug {
    void plugIntoAmericanSocket();
}

// EuropeanPowerSocket interface
interface EuropeanPowerSocket {
    void plugIntoEuropeanSocket();
}

// AmericanPowerPlugImpl class
class AmericanPowerPlugImpl implements AmericanPowerPlug {
    @Override
    public void plugIntoAmericanSocket() {
        System.out.println("Plugged into American socket");
    }
}

// EuropeanPowerSocketImpl class
class EuropeanPowerSocketImpl implements EuropeanPowerSocket {
    @Override
    public void plugIntoEuropeanSocket() {
        System.out.println("Plugged into European socket");
    }
}

// Adapter class to make AmericanPowerPlug compatible with EuropeanPowerSocket
class AmericanToEuropeanAdapter implements EuropeanPowerSocket {
    private AmericanPowerPlug americanPowerPlug;

    public AmericanToEuropeanAdapter(AmericanPowerPlug americanPowerPlug) {
        this.americanPowerPlug = americanPowerPlug;
    }

    @Override
    public void plugIntoEuropeanSocket() {
        System.out.println("Adapter converts and ");
        americanPowerPlug.plugIntoAmericanSocket();
    }
}

// Main class
public class PowerPlugSimulation {
    public static void main(String[] args) {
        // Using American power plug with American socket
        AmericanPowerPlug americanPlug = new AmericanPowerPlugImpl();
        americanPlug.plugIntoAmericanSocket();

        // Using European power socket with European plug
        EuropeanPowerSocket europeanSocket = new EuropeanPowerSocketImpl();
        europeanSocket.plugIntoEuropeanSocket();

        // Using American power plug with European socket using the adapter
        AmericanToEuropeanAdapter adapter = new AmericanToEuropeanAdapter(americanPlug);
        adapter.plugIntoEuropeanSocket();
    }
}
