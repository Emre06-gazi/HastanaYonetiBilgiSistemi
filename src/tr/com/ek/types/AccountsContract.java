package tr.com.ek.types;

public class AccountsContract {
	private int id;
	private String kullaniciAdi;
	private int PersonelID;

	public int getPersonelID() {
		return PersonelID;
	}

	public void setPersonelID(int personelID) {
		PersonelID = personelID;
	}

	private int rolID;
	private String sifre;

	@Override
	public String toString() {
		return id + " " + kullaniciAdi;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public int getRolID() {
		return rolID;
	}

	public void setRolID(int rolID) {
		this.rolID = rolID;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

}
