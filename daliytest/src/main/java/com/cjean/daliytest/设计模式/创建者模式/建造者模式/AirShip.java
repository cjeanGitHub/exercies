package com.cjean.daliytest.设计模式.创建者模式.建造者模式;

public class AirShip {
	private OrbitalModel orbitalModel;
	private Engine engine;
	private EscapeTower escapeTower;
	
	public OrbitalModel getOrbitalModel() {
		return orbitalModel;
	}
	public void setOrbitalModel(OrbitalModel orbitalModel) {
		this.orbitalModel = orbitalModel;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public EscapeTower getEscapeTower() {
		return escapeTower;
	}
	public void setEscapeTower(EscapeTower escapeTower) {
		this.escapeTower = escapeTower;
	}
	
}

class OrbitalModel{
	private String Oname;

	public OrbitalModel(String oname) {
		Oname = oname;
	}

	public String getOname() {
		return Oname;
	}

	public void setOname(String oname) {
		Oname = oname;
	}
	
	
}
class Engine{
	private String Ename;

	public Engine(String ename) {
		Ename = ename;
	}

	public String getEname() {
		return Ename;
	}

	public void setEname(String ename) {
		Ename = ename;
	}
	
}
class EscapeTower{
	private String name;

	public EscapeTower(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}