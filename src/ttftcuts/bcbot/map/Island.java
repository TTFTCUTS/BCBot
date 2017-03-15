package ttftcuts.bcbot.map;

import java.util.ArrayList;
import java.util.List;

public class Island {
    public List<Region> regions = new ArrayList<Region>();

    public Island() {

    }

    public void addRegion(Region region) {
        this.regions.add(region);
        region.island = this;
    }
}
