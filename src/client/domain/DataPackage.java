/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package client.domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pinnacle F
 */
public class DataPackage {

    Map<String, String[]> dataPacket;

    /**
     * No arg that initialises the hashmap
     */
    public DataPackage() {
        dataPacket = new HashMap<>();
    }

    /**
     * initialises with map
     * @param dataPacket 
     */
    public DataPackage(Map<String, String[]> dataPacket) {
        this.dataPacket = dataPacket;
    }

    public DataPackage(String[] dataArray, String identifier) {
        this.dataPacket = new HashMap<>();
        this.dataPacket.put(identifier, dataArray);
    }

    public Map<String, String[]> getDataPacket() {
        return dataPacket;
    }

    public boolean addDataPoint(String[] dataArray, String identifier) {
        return dataPacket.put(identifier, dataArray) == null;
    }

    public boolean replaceDataPoint(String[] dataArray, String identifier) {
        return this.dataPacket.replace(identifier, dataArray) != null;
    }

    public boolean removeDataPoint(String identifier) {
        return this.dataPacket.remove(identifier) != null;
    }
}
