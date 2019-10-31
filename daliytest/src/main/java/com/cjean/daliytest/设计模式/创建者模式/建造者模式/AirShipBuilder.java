package com.cjean.daliytest.设计模式.创建者模式.建造者模式;

public interface AirShipBuilder {
	Engine builderEngine();
	OrbitalModel builderOrbitalModel();
	EscapeTower builderEscapeTower();
}
