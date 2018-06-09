package com.doc.online.idgenerators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class DocBookingIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix = "DOCBK";
		Connection connection = session.connection();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select count(doc_booking_id) as Id from onlinedoc.booking_doc");
			if (resultSet.next()) {
				int id = resultSet.getInt(1) + 101;
				String generatedId = prefix + new Integer(id).toString();
				return generatedId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
