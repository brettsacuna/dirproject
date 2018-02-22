package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Item_proyecto;

public class Item_proyectoDao implements Intermetodos<Item_proyecto>{

	@Override
	public void Grabar(Item_proyecto o) throws Exception {
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();			
			cn.setAutoCommit(false);
			
			String sql = " insert into item_proyecto("
					+ "id_proyecto, "
					+ "item_descripcion, "
					+ "etapa_proyecto, "
					+ "estado_proyecto, "
					+ "ubicacion, "
					+ "presupuesto_expediente_tecnico,"
					+ "valor_referencial, "
					+ "usuario, "
					+ "fecha_registro, "					
					+ "activo) "
					+ "values(?,?,?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_proyecto());
			pstm.setString(2, o.getItem_descripcion());
			pstm.setInt(3, o.getEtapa_proyecto());
			pstm.setInt(4, o.getEstado_proyecto());
			pstm.setString(5, o.getUbicacion());
			pstm.setDouble(6, o.getPresupuesto_expediente_tecnico());
			pstm.setDouble(7, o.getValor_referencial());
			pstm.setString(8, o.getUsuario());
					
			pstm.executeUpdate();

			pstm.close();

			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception exception) {
				exception.printStackTrace();
			}

			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void Eliminar(Item_proyecto o) throws Exception {

		Connection cn = null;
		
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = "update item_proyecto set activo = 0, fecha_ultima_modificacion = sysdate() where id_item_proyecto = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_item_proyecto());
			
			pstm.executeUpdate();

			pstm.close();

			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception exception) {
				exception.printStackTrace();
			}

			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void Modificar(Item_proyecto o) throws Exception {
		
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = " update item_proyecto  set "
					+ "item_descripcion = ?, "
					+ "etapa_proyecto = ?, "
					+ "estado_proyecto = ?, "
					+ "ubicacion = ?, "
					+ "presupuesto_expediente_tecnico = ?,"
					+ "valor_referencial = ?,"
					+ " usuario = ?, "
					+ " fecha_ultima_modificacion = sysdate() "
					+ " where id_item_proyecto = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getItem_descripcion());
			pstm.setInt(2, o.getEtapa_proyecto());
			pstm.setInt(3, o.getEstado_proyecto());
			pstm.setString(4, o.getUbicacion());
			pstm.setDouble(5, o.getPresupuesto_expediente_tecnico());
			pstm.setDouble(6, o.getValor_referencial());
			pstm.setString(7, o.getUsuario());
						
			pstm.setInt(8, o.getId_item_proyecto());

			pstm.executeUpdate();

			pstm.close();

			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception exception) {
				exception.printStackTrace();
			}

			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Item_proyecto> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item_proyecto> Filtrar(Item_proyecto o) throws Exception {
		
		 Connection cn = null;
		 
	        List<Item_proyecto> lista = new ArrayList<Item_proyecto>();
	        
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql ="select "
	            		+ "id_item_proyecto,"
	            		+ "id_proyecto, "
	            		+ "item_descripcion, "
						+ "etapa_proyecto, "
						+ "estado_proyecto, "
						+ "ubicacion, "
						+ "presupuesto_expediente_tecnico,"
						+ "valor_referencial, "
						+ "usuario "
	            		+ " from  item_proyecto "
	            		+ " where id_proyecto = ? "
	            		+ " and activo = 1 order by id_item_proyecto asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_proyecto());

	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Item_proyecto ip = new Item_proyecto();
		
					ip.setId_item_proyecto(rs.getInt("id_item_proyecto"));
					ip.setId_proyecto(rs.getInt("id_proyecto"));
					ip.setItem_descripcion(rs.getString("item_descripcion"));
					ip.setEtapa_proyecto(rs.getInt("etapa_proyecto"));
					ip.setEstado_proyecto(rs.getInt("estado_proyecto"));
					ip.setUbicacion(rs.getString("ubicacion"));
					ip.setPresupuesto_expediente_tecnico(rs.getDouble("presupuesto_expediente_tecnico"));
					ip.setValor_referencial(rs.getDouble("valor_referencial"));
					ip.setUsuario(rs.getString("usuario"));
				
					lista.add(ip);
	            }
	            // cerrar cursor
	            rs.close();
	            pstm.close();
	        } catch (Exception e) {
	            throw e;
	        } finally {
	            try {
	                cn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return lista;
	}

	@Override
	public Item_proyecto Buscar(Item_proyecto o) throws Exception {
		
			Connection cn = null;
		 
	        Item_proyecto ip = new Item_proyecto();
	        
	        try {
	        	
	            cn = DataAccess.getConnection();

	            String sql = " select "
	            		+ "id_item_proyecto, "
	            		+ "item_descripcion,"	            		
						+ "etapa_proyecto, "
						+ "estado_proyecto, "
						+ "ubicacion, "
						+ "presupuesto_expediente_tecnico,"
						+ "valor_referencial "	            		
	            		+ " from item_proyecto "
	            		+ " where id_item_proyecto = ? and activo = 1 ";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setInt(1, o.getId_item_proyecto());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	ip.setId_item_proyecto(rs.getInt("id_item_proyecto"));
	            	ip.setItem_descripcion(rs.getString("item_descripcion"));
	            	ip.setEtapa_proyecto(rs.getInt("etapa_proyecto"));
					ip.setEstado_proyecto(rs.getInt("estado_proyecto"));
					ip.setUbicacion(rs.getString("ubicacion"));
					ip.setPresupuesto_expediente_tecnico(rs.getDouble("presupuesto_expediente_tecnico"));
					ip.setValor_referencial(rs.getDouble("valor_referencial"));
					
	            }
	            rs.close();
	            pstm.close();
	        } catch (Exception e) {
	            throw e;
	        } finally {
	            try {
	                cn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return ip;
	}

}
