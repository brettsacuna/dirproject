package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Proceso_seleccion_item;

public class Proceso_seleccion_itemDao  implements Intermetodos<Proceso_seleccion_item>{

	@Override
	public void Grabar(Proceso_seleccion_item o) throws Exception {
		
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();			
			cn.setAutoCommit(false);
			
			String sql = " insert into proceso_seleccion_item("
					+ " id_proceso_seleccion,"
					+ " item_descripcion, "
					+ " valor_referencial, "
					+ " fecha_valor_referencial, "
					+ " plazo_ejecucion, "
					+ " situacion, "
					+ " usuario, "
					+ " fecha_registro,"
					+ "	activo ) "
					+ "values(?,?,?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_proceso_seleccion());
			pstm.setInt(2, o.getId_item_proyecto());
			pstm.setString(3, o.getItem_descripcion());	
			pstm.setDouble(4, o.getValor_referencial());
			pstm.setString(5, o.getFecha_valor_referencial());
			pstm.setInt(6, o.getPlazo_ejecucion());
			pstm.setString(7, o.getSituacion());
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
	public void Eliminar(Proceso_seleccion_item o) throws Exception {
		
		Connection cn = null;
		
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update proceso_seleccion_item set activo = 0 where id_proceso_seleccion_item = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_proceso_seleccion_item());
			
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
	public void Modificar(Proceso_seleccion_item o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = " update proceso_seleccion_item  set "
					+ " id_item_proyecto = ?,"					
					+ " item_descripcion = ?, "
					+ " valor_referencial = ?, "
					+ " fecha_valor_referencial = ?, "
					+ " plazo_ejecucion = ?, "
					+ " situacion = ?,"
					+ " usuario = ?, "
					+ " fecha_ultima_modificacion = sysdate() "
					+ " where id_proceso_seleccion_item = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_item_proyecto());
			pstm.setString(2, o.getItem_descripcion());
			pstm.setDouble(3, o.getValor_referencial());
			pstm.setString(4, o.getFecha_valor_referencial());
			pstm.setInt(5, o.getPlazo_ejecucion());
			pstm.setString(6, o.getSituacion());
			pstm.setString(7, o.getUsuario());
			
			pstm.setInt(8, o.getId_proceso_seleccion_item());

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
	public List<Proceso_seleccion_item> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proceso_seleccion_item> Filtrar(Proceso_seleccion_item o) throws Exception {
		 Connection cn = null;
	        List<Proceso_seleccion_item> lista = new ArrayList<Proceso_seleccion_item>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql ="select "
	            		+ " id_proceso_seleccion_item,"
	            		+ " id_proceso_seleccion,"
	            		+ " id_item_proyecto,"
	            		+ "	item_descripcion, "
	            		+ " valor_referencial, "
	            		+ " fecha_valor_referencial, "
	            		+ " plazo_ejecucion, "
	            		+ " situacion, "
	            		+ " usuario "	            		 
	            		+ " from proceso_seleccion_item "
	            		+ " where id_proceso_seleccion = ? "
	            		+ " and activo = 1 order by id_proceso_seleccion_item asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_proceso_seleccion());

	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Proceso_seleccion_item psi = new Proceso_seleccion_item();
		
					psi.setId_proceso_seleccion_item(rs.getInt("id_proceso_seleccion_item"));
					psi.setId_proceso_seleccion(rs.getInt("id_proceso_seleccion"));
					psi.setId_item_proyecto(rs.getInt("id_item_proyecto"));
					psi.setItem_descripcion(rs.getString("item_descripcion"));
					psi.setValor_referencial(rs.getDouble("valor_referencial"));
					psi.setFecha_valor_referencial(rs.getString("fecha_valor_referencial"));
					psi.setPlazo_ejecucion(rs.getInt("plazo_ejecucion"));
					psi.setSituacion(rs.getString("situacion"));
					psi.setUsuario(rs.getString("usuario"));

					lista.add(psi);
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
	public Proceso_seleccion_item Buscar(Proceso_seleccion_item o) throws Exception {
		 	Connection cn = null;
	        Proceso_seleccion_item psi = new Proceso_seleccion_item();
	        try {
	            cn = DataAccess.getConnection();

	            String sql = " select "
	            		+ " id_proceso_seleccion_item,"
	            		+ " id_item_proyecto,"
	            		+ "	item_descripcion, "
	            		+ " valor_referencial, "
	            		+ " date_format(fecha_valor_referencial, '%m/%d/%Y') as fecha_valor_referencial, "
	            		+ " plazo_ejecucion, "
	            		+ " situacion "
	            		+ " from proceso_seleccion_item "
	            		+ " where id_proceso_seleccion_item = ? and activo = 1 ";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setInt(1, o.getId_proceso_seleccion_item());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	psi.setId_proceso_seleccion_item(rs.getInt("id_proceso_seleccion_item"));
	            	psi.setId_item_proyecto(rs.getInt("id_item_proyecto"));
	            	psi.setItem_descripcion(rs.getString("item_descripcion"));
	            	psi.setValor_referencial(rs.getDouble("valor_referencial"));
	            	psi.setFecha_valor_referencial(rs.getString("fecha_valor_referencial"));
	            	psi.setPlazo_ejecucion(rs.getInt("plazo_ejecucion"));
	            	psi.setSituacion(rs.getString("situacion"));

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
	        return psi;
	}
	

}
