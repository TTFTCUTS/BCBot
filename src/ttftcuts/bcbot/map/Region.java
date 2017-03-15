package ttftcuts.bcbot.map;

import bwapi.Color;
import ttftcuts.bcbot.util.Drawing;

public class Region {

    public final bwta.Region region;

    public Island island = null;

    public Region(bwta.Region bwtaRegion) {
        this.region = bwtaRegion;
    }

    public Color getRegionColour() {
        return Color.Grey;
    }

    public void draw() {
        Drawing.drawPolygonMap(this.region.getPolygon(), this.getRegionColour());
    }
}
