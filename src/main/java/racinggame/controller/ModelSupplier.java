package racinggame.controller;

import java.util.List;

import racinggame.model.CarName;
import racinggame.model.Turn;

public interface ModelSupplier {
	List<CarName> askCarNames();
	Turn askTurnNum();
}
