package tr.com.ek.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.ek.core.ObjectHelper;
import tr.com.ek.interfaces.DALInterfaces;
import tr.com.ek.types.AccountsContract;


public class AccountDAL extends ObjectHelper implements DALInterfaces<AccountsContract> {

	@Override
	public void Insert(AccountsContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("INSERT INTO Useraccounts (KullaniciAdi, PersonelID, Sifre, RolID) VALUES('" + entity.getKullaniciAdi() +"', " + entity.getPersonelID() + ",'" + entity.getSifre() + "', " + entity.getRolID() + ")");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public AccountsContract GetPersonelIdVeSifre(int personelID, String sifre) {

		AccountsContract contract = new AccountsContract();
		List<AccountsContract> listele = new ArrayList<AccountsContract>();
		
		Connection baglanti = getConnection();
		try {
			Statement sorgu = baglanti.createStatement();
			ResultSet rs = sorgu.executeQuery(
					"SELECT * From Useraccounts WHERE PersonelID = " + personelID + " AND Sifre = '" + sifre.trim() + "' ");

			while (rs.next()) {
				contract.setId(rs.getInt("KullaniciID"));
				contract.setKullaniciAdi(rs.getString("KullaniciAdi"));
				contract.setPersonelID(rs.getInt("PersonelID"));
				contract.setRolID(rs.getInt("RolID"));
				contract.setSifre(rs.getString("Sifre"));
				
			}
			sorgu.close();
			baglanti.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return contract;
	}

	public AccountsContract GetRolId(int personelId) {

		AccountsContract contract = new AccountsContract();
		List<AccountsContract> listele = new ArrayList<AccountsContract>();
		Connection baglanti = getConnection();
		try {
			Statement sorgu = baglanti.createStatement();
			ResultSet rs = sorgu.executeQuery("SELECT * From Useraccounts WHERE PersonelID = " + personelId + " ");

			while (rs.next()) {
				contract.setId(rs.getInt("KullaniciID"));
				contract.setKullaniciAdi(rs.getString("KullaniciAdi"));
				contract.setPersonelID(rs.getInt("PersonelID"));
				contract.setSifre(rs.getString("Sifre"));
				contract.setRolID(rs.getInt("RolID	"));
			}
			sorgu.close();
			baglanti.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return contract;
	}

	@Override
	public List<AccountsContract> GetAll() {
		List<AccountsContract> datacontract = new ArrayList<AccountsContract>();
		Connection connection = getConnection();
		AccountsContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Useraccounts");
			while (resultSet.next()) {
				contract = new AccountsContract();
				contract.setId(resultSet.getInt("KullaniciID"));
				contract.setKullaniciAdi(resultSet.getString("KullaniciAdi"));
				contract.setPersonelID(resultSet.getInt("PersonelID"));
				contract.setSifre(resultSet.getString("Sifre"));
				contract.setRolID(resultSet.getInt("RolID"));
				
				datacontract.add(contract);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}
	
	public List<AccountsContract> GetSearchMusteri(String personelId) {

		List<AccountsContract> datacontract = new ArrayList<AccountsContract>();
		Connection connection = getConnection();
		AccountsContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM Useraccounts Where PersonelID Like '" + "%" + personelId + "%" + "' ");
			while (resultSet.next()) {
				contract = new AccountsContract();
				contract.setId(resultSet.getInt("KullaniciID"));
				contract.setKullaniciAdi(resultSet.getString("KullaniciAdi"));
				contract.setPersonelID(resultSet.getInt("PersonelID"));
				contract.setSifre(resultSet.getString("Sifre"));
				contract.setRolID(resultSet.getInt("RolID	"));

				datacontract.add(contract);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}
	
	@Override
	public AccountsContract Delete(AccountsContract Entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(AccountsContract Entity) {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE Useraccounts SET Kullanici Adi = ?, RolID = ?, Sifre = ? WHERE KullaniciID = ?")) {

			preparedStatement.setInt(1, Entity.getId());
			preparedStatement.setString(2, Entity.getKullaniciAdi());
			preparedStatement.setString(3, Entity.getSifre());
			preparedStatement.setInt(4, Entity.getRolID());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public List<AccountsContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
