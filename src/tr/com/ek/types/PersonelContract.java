package tr.com.ek.types;

public class PersonelContract {
	private int id;
	private String adiSoyadi;
	private String telefonNumarasi;
	private int rolID;

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAdiSoyadi() {
		return adiSoyadi;
	}



	public void setAdiSoyadi(String adiSoyadi) {
		this.adiSoyadi = adiSoyadi;
	}



	public String getTelefonNumarasi() {
		return telefonNumarasi;
	}



	public void setTelefonNumarasi(String telefonNumarasi) {
		this.telefonNumarasi = telefonNumarasi;
	}



	public int getRolID() {
		return rolID;
	}



	public void setRolID(int rolID) {
		this.rolID = rolID;
	}



	@Override
	public String toString() {
		return id + " " +adiSoyadi;

	}
}
