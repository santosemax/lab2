package edu.uc.cs3003.medava;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Transporter {


    private String mTransporterName;
    public String getTransporterName() {
        return mTransporterName;
    }

    private List<Shippable> goods;
    
    {
        goods = new ArrayList<Shippable>();
    }

    public void ship() {
        // Do some shipping!
    }

    private double mLowTemperature, mHighTemperature;

    // Constructor
    public Transporter(String transporterName, double lowTemp, double highTemp) {
        mTransporterName = transporterName;
        mLowTemperature = lowTemp;
        mHighTemperature = highTemp;
    }

    // (OLD) Load method
    // public boolean load(Medicine itemToLoad) {
    //     if (itemToLoad.isTemperatureRangeAcceptable(mLowTemperature, mHighTemperature)) {
    //         System.out.println(String.format("Adding a %s to the transporter.", itemToLoad.getMedicineName()));
    //         goods.add(itemToLoad);
    //         return true;
    //     }
    //     return false;
    // }

    // Object Load method (REFLECTION)
    //     public boolean load(Object itemToLoad) {
    //     try {
    //         Method isTemperatureRangeAcceptableMethod = itemToLoad.getClass().getMethod("isTemperatureRangeAcceptable",
    //                 Double.class, Double.class);
    //         boolean resultOfMethodCall = (boolean) isTemperatureRangeAcceptableMethod.invoke(itemToLoad,
    //                 Double.valueOf(mLowTemperature), Double.valueOf(mHighTemperature));
    //         if (resultOfMethodCall) {
    //             goods.add(itemToLoad);
    //         }
    //         return resultOfMethodCall;
    //     } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
    //             | InvocationTargetException e) {
    //         return false;
    //     }
    // }
    // public Object unload() {
        // return goods.remove(0);
    // }

    // Shippable unload method
    public Shippable unload() {
        return goods.remove(0);
    }

    // Shippable load method
    public boolean load(Shippable itemToLoad) {
        if (itemToLoad.isTemperatureRangeAcceptable(mLowTemperature, mHighTemperature)) {
            return goods.add(itemToLoad);
        }
        return false;
    }

    public boolean isEmpty() {
        return goods.isEmpty();
    }
}