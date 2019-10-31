package com.cjean.daliytest.设计模式.创建者模式.建造者模式;

public class SxtAirShipBuilder implements AirShipBuilder {

	@Override
	public Engine builderEngine() {
		return new Engine("尚学堂的发动机");
	}

	@Override
	public OrbitalModel builderOrbitalModel() {
		return new OrbitalModel("尚学堂的轨道舱");
	}

	@Override
	public EscapeTower builderEscapeTower() {
		return new EscapeTower("尚学堂的逃生舱");
	}

}
