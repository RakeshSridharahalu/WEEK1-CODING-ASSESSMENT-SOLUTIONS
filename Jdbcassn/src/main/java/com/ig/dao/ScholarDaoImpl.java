package com.ig.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ig.model.Scholar;
import com.ig.util.DbUtil;

public class ScholarDaoImpl implements ScholarDao {
	@Override
    public void addScholar(Scholar scholar) throws Exception {
        Connection c = DbUtil.getConnectioin();
        PreparedStatement p = c.prepareStatement("INSERT INTO scholar (scholarId, Name, Email, Mobile) VALUES (?, ?, ?, ?)");
        p.setInt(1, scholar.getScholarId());
        p.setString(2, scholar.getName());
        p.setString(3, scholar.getEmail());
        p.setString(4, scholar.getMobile());
        p.execute();
    }

    @Override
    public List<Scholar> listAllScholars() throws Exception {
        ArrayList<Scholar> scholarList = new ArrayList<>();
        Connection c = DbUtil.getConnectioin();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM scholar");
        while (rs.next()) {
            Scholar scholar = new Scholar();
            scholar.setScholarId(rs.getInt(1));
            scholar.setName(rs.getString(2));
            scholar.setEmail(rs.getString(3));
            scholar.setMobile(rs.getString(4));
            scholarList.add(scholar);
        }
        return scholarList;
    }

    @Override
    public Scholar findScholarById(int id) throws Exception {
        Connection c = DbUtil.getConnectioin();
        PreparedStatement p = c.prepareStatement("SELECT * FROM scholar WHERE scholarId= ?");
        Scholar scholar = new Scholar();
        p.setInt(1, id);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            scholar.setScholarId(r.getInt("scholarId"));
            scholar.setName(r.getString("Name"));
            scholar.setEmail(r.getString("Email"));
            scholar.setMobile(r.getString("Mobile"));
            return scholar;
        } else {
            System.out.println("Scholar not found.");
            return null;
        }
    }

    @Override
    public void deleteScholarById(int id) throws Exception {
        Connection c = DbUtil.getConnectioin();
        PreparedStatement p = c.prepareStatement("DELETE FROM scholar WHERE scholarId = ?");
        p.setInt(1, id);
        int rowDeleted = p.executeUpdate();
        if (rowDeleted > 0) {
            System.out.println("Deleted successfully");
        } else {
            System.out.println("Scholar not found");
        }
    }

    @Override
    public void updateScholarEmail(int id, String email) throws Exception {
        Connection c = DbUtil.getConnectioin();
        PreparedStatement p = c.prepareStatement("UPDATE scholar SET Email = ? WHERE scholarId = ?");
        p.setString(1, email);
        p.setInt(2, id);

        int rowUpdated = p.executeUpdate();
        if (rowUpdated > 0) {
            System.out.println("Updated successfully");
        } else {
            System.out.println("Scholar not found");
        }
    }
}
