package ttftcuts.bcbot.map;

import bwapi.Position;
import bwapi.TilePosition;
import bwta.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BWMap {

    public List<Region> regions;
    public Map<bwta.Region, Region> regionmap = new HashMap<>();

    public List<Island> islands = new ArrayList<>();

    public List<BaseLocation> baseLocations;

    public BWMap() {
        BWTA.readMap();
        BWTA.analyze();

        List<bwta.Region> bwtaregions = BWTA.getRegions();
        this.regions = new ArrayList<>();

        bwta.Region bwtaregion;
        Region mapregion;

        for (int i = 0; i < bwtaregions.size(); i++) {
            bwtaregion = bwtaregions.get(i);
            mapregion = new Region(bwtaregion);
            this.regions.add(mapregion);
            this.regionmap.put(bwtaregion, mapregion);
        }

        for (Region region : this.regions) {
            if (region.island == null) {
                Island isle = new Island();
                this.islands.add(isle);

                isle.addRegion(region);

                for (bwta.Region r : region.region.getReachableRegions()) {
                    isle.addRegion(this.regionmap.get(r));
                }
            }
        }

        this.baseLocations = BWTA.getBaseLocations();
    }

    public Region getRegion(TilePosition pos) {
        return this.regionmap.get(BWTA.getRegion(pos));
    }

    public Region getRegion(Position pos) {
        return this.regionmap.get(BWTA.getRegion(pos));
    }

    public Region getRegion(int x, int y) {
        return this.regionmap.get(BWTA.getRegion(x,y));
    }

    public void draw() {
        for (Region r : this.regions) {
            r.draw();
        }

        /*
        Drawing.Colours.drawPalette();

        int[] greens = new int[]{181,182,183,184,185,186,187,188,189,190,191};
        int[] skinbrowns = new int[]{86,87,89,93,99,107,114};

        Drawing.Colours.drawColourSeries(350, 200, 86,87,89,93,99,25,107);
        */
    }
}
