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

import tr.com.ek.types.PersonelContract;

public class PersonelDAL extends ObjectHelper implements DALInterfaces<PersonelContract>{

	@Override
	public void Insert(PersonelContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			
			statement.executeUpdate("INSERT INTO Staff (AdiSoyadi, RolID, TelefonNumarasi) VALUES('"+entity.getAdiSoyadi()+"',"+entity.getRolID()+",'"+entity.getTelefonNumarasi()+"')"); 
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<PersonelContract> GetAll() {
		List<PersonelContract> datacontract = new ArrayList<PersonelContract>();
		Connection connection = getConnection();
		PersonelContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Staff");
			while(resultSet.next()) {
				contract = new PersonelContract();
				contract.setId(resultSet.getInt("PersonelID"));
				contract.setAdiSoyadi(resultSet.getString("AdiSoyadi"));
				contract.setRolID(resultSet.getInt("RolID"));
				contract.setTelefonNumarasi(resultSet.getString("TelefonNumarasi"));
				datacontract.add(contract);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	@Override
	public PersonelContract Delete(PersonelContract Entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<PersonelContract> GetSearchPerson(String personAdi) {

		List<PersonelContract> datacontract = new ArrayList<PersonelContract>();
		Connection connection = getConnection();
		PersonelContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM Staff Where AdiSoyadi Like '" + "%" + personAdi + "%" + "' ");
			while (resultSet.next()) {
				contract = new PersonelContract();
				contract.setId(resultSet.getInt("PersonelID"));
				contract.setAdiSoyadi(resultSet.getString("AdiSoyadi"));
				contract.setRolID(resultSet.getInt("RolID"));
				contract.setTelefonNumarasi(resultSet.getString("TelefonNumarasi"));

				datacontract.add(contract);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}
	
	@Override
	public void Update(PersonelContract Entity) {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE Staff SET AdiSoyadi = ?, RolID = ?, Telefon Numarasi = ? WHERE PersonelID = ?")) {

			preparedStatement.setString(1, Entity.getAdiSoyadi());
			preparedStatement.setInt(2, Entity.getRolID());
			preparedStatement.setString(3, Entity.getTelefonNumarasi());
			preparedStatement.setInt(4, Entity.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<PersonelContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}
