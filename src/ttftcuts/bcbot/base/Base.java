package ttftcuts.bcbot.base;

import bwta.BaseLocation;
import ttftcuts.bcbot.map.Region;
import ttftcuts.bcbot.unit.Structure;
import ttftcuts.bcbot.unit.Unit;
import ttftcuts.bcbot.unit.structure.CommandCentre;

import java.util.ArrayList;
import java.util.List;

public class Base {

    public Region region;

    public List<Structure> structures = new ArrayList<>();
    public List<Unit> workers = new ArrayList<>();
    public List<Unit> miners = new ArrayList<>();

    public CommandCentre command = null;
    public BaseLocation location = null;

    public Base(Region region) {
        this.region = region;
    }

    public void setBaseLocation(BaseLocation location) {
        this.location = location;
    }

    public void setCommandCentre(CommandCentre cc) {
        this.command = cc;
        if (!this.structures.contains(cc)) {
            this.structures.add(cc);
        }
    }

    public void addWorker(Unit worker) {
        this.workers.add(worker);
    }

    public void update() {

    }
}
