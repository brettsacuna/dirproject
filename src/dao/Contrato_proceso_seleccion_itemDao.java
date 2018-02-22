package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import database.DataAccess;
import entity.Contrato_proceso_seleccion_item;

public class Contrato_proceso_seleccion_itemDao implements Intermetodos<Contrato_proceso_seleccion_item>{

	@Override
	public void Grabar(Contrato_proceso_seleccion_item o) throws Exception {
		
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();			
			cn.setAutoCommit(false);
			
			String sql = " insert into contrato_proceso_seleccion_item("
					+" id_proceso_seleccion_item, "
					+ "fecha_adjudicacion, "
					+ "monto_adjudicado, "
					+ "monto_pagado, "
					+ "porcentaje_pagado, "
					+ "contratista_adjudicado, "
					+ "ruc_contratista, "
					+ "numero_contrato, "
					+ "fecha_firma_contrato, "
					+ "fecha_entrega_terreno, "
					+ "plazo_ejecucion, "
					+ "fecha_inicio_plazo_contractual, "
					+ "total_dias_ampliacion_plazo, "
					+ "total_adendas, "
					+ "monto_prestaciones_adicionales, "
					+ "observaciones, "
					+ "liquidacion, "
					+ "usuario, "
					+ "fecha_registro, "					
					+ "activo)  " 	
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_proceso_seleccion_item());
			pstm.setString(2, o.getFecha_adjudicacion());	
			pstm.setDouble(3, o.getMonto_adjudicado());
			pstm.setDouble(4, o.getMonto_pagado());
			pstm.setDouble(5, o.getPorcentaje_pagado());
			pstm.setString(6, o.getContratista_adjudicado());
			pstm.setString(7, o.getRuc_contratista());
			pstm.setString(8, o.getNumero_contrato());
			pstm.setString(9, o.getFecha_firma_contrato());
			pstm.setString(10, o.getFecha_entrega_terreno());
			pstm.setInt(11, o.getPlazo_ejecucion());
			pstm.setString(12, o.getFecha_inicio_plazo_contractual());
			pstm.setInt(13, o.getTotal_dias_ampliacion_plazo());
			pstm.setInt(14, o.getTotal_adendas());
			pstm.setDouble(15, o.getMonto_prestaciones_adicionales());
			pstm.setString(16, o.getObservaciones());
			pstm.setString(17, o.getLiquidacion());
			pstm.setString(18, o.getUsuario());
			
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
	public void Eliminar(Contrato_proceso_seleccion_item o) throws Exception {
		
		Connection cn = null;
		
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update contrato_proceso_seleccion_item set activo = 0, fecha_ultima_modificacion = sysdate() where id_contrato_proceso_seleccion_item = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
			
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
	public void Modificar(Contrato_proceso_seleccion_item o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = " update contrato_proceso_seleccion_item  set "
					+ "fecha_adjudicacion = ?, "
					+ "monto_adjudicado = ?, "
					+ "monto_pagado = ?, "
					+ "porcentaje_pagado = ?, "
					+ "contratista_adjudicado = ?, "
					+ "ruc_contratista = ?, "
					+ "numero_contrato = ?, "
					+ "fecha_firma_contrato = ?, "
					+ "fecha_entrega_terreno = ?, "
					+ "plazo_ejecucion = ?, "
					+ "fecha_inicio_plazo_contractual = ?, "
					+ "total_dias_ampliacion_plazo = ?, "
					+ "total_adendas = ?, "
					+ "monto_prestaciones_adicionales = ?, "
					+ "observaciones = ?, "
					+ "liquidacion = ?, "
					+ "usuario = ?,"	
					+ " fecha_ultima_modificacion = sysdate() "
					+ " where id_contrato_proceso_seleccion_item = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getFecha_adjudicacion());
			pstm.setDouble(2, o.getMonto_adjudicado());
			pstm.setDouble(3, o.getMonto_pagado());
			pstm.setDouble(4, o.getPorcentaje_pagado());
			pstm.setString(5, o.getContratista_adjudicado());			
			pstm.setString(6, o.getRuc_contratista());
			pstm.setString(7, o.getNumero_contrato());
			pstm.setString(8, o.getFecha_firma_contrato());
			pstm.setString(9,o.getFecha_entrega_terreno());
			pstm.setInt(10, o.getPlazo_ejecucion());
			pstm.setString(11,o.getFecha_inicio_plazo_contractual());
			pstm.setInt(12,o.getTotal_dias_ampliacion_plazo());
			pstm.setInt(13,o.getTotal_adendas());
			pstm.setDouble(14,o.getMonto_prestaciones_adicionales());
			pstm.setString(15,o.getObservaciones());
			pstm.setString(16,o.getLiquidacion());
			pstm.setString(17,o.getUsuario());
			
			pstm.setInt(18,o.getId_contrato_proceso_seleccion_item());

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
	public List<Contrato_proceso_seleccion_item> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contrato_proceso_seleccion_item> Filtrar(Contrato_proceso_seleccion_item o) throws Exception {
		 
		Connection cn = null;
	    
		List<Contrato_proceso_seleccion_item> lista = new ArrayList<Contrato_proceso_seleccion_item>();
	    
		try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql = "select "
	            		+ "id_contrato_proceso_seleccion_item, "
	            		+ "id_proceso_seleccion_item, "
						+ "fecha_adjudicacion, "
						+ "monto_adjudicado, "
						+ "monto_pagado, "
						+ "porcentaje_pagado, "
						+ "contratista_adjudicado, "
						+ "ruc_contratista, "
						+ "numero_contrato, "
						+ "fecha_firma_contrato, "
						+ "fecha_entrega_terreno, "
						+ "plazo_ejecucion, "
						+ "fecha_inicio_plazo_contractual, "
						+ "total_dias_ampliacion_plazo, "
						+ "total_adendas, "
						+ "monto_prestaciones_adicionales, "
						+ "observaciones, "
						+ "liquidacion, "
						+ "usuario " 
	            		+ " from contrato_proceso_seleccion_item "
	            		+ " where id_proceso_seleccion_item = ? "
	            		+ " and activo = 1 order by id_contrato_proceso_seleccion_item asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_proceso_seleccion_item());

	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Contrato_proceso_seleccion_item cpsi = new Contrato_proceso_seleccion_item();
		
					cpsi.setId_contrato_proceso_seleccion_item(rs.getInt("id_contrato_proceso_seleccion_item"));
					cpsi.setId_proceso_seleccion_item(rs.getInt("id_proceso_seleccion_item"));
					cpsi.setFecha_adjudicacion(rs.getString("fecha_adjudicacion"));
					cpsi.setMonto_adjudicado(rs.getDouble("monto_adjudicado"));
					cpsi.setMonto_pagado(rs.getDouble("monto_pagado"));
					cpsi.setPorcentaje_pagado(rs.getDouble("porcentaje_pagado"));
					cpsi.setContratista_adjudicado(rs.getString("contratista_adjudicado"));
					cpsi.setRuc_contratista(rs.getString("ruc_contratista"));
					cpsi.setNumero_contrato(rs.getString("numero_contrato"));
					cpsi.setFecha_firma_contrato(rs.getString("fecha_firma_contrato"));
					cpsi.setFecha_entrega_terreno(rs.getString("fecha_entrega_terreno"));
					cpsi.setPlazo_ejecucion(rs.getInt("plazo_ejecucion"));
					cpsi.setFecha_inicio_plazo_contractual(rs.getString("fecha_inicio_plazo_contractual"));
					cpsi.setTotal_dias_ampliacion_plazo(rs.getInt("total_dias_ampliacion_plazo"));
					cpsi.setTotal_adendas(rs.getInt("total_adendas"));
					cpsi.setMonto_prestaciones_adicionales(rs.getDouble("monto_prestaciones_adicionales"));
					cpsi.setObservaciones(rs.getString("observaciones"));
					cpsi.setLiquidacion(rs.getString("liquidacion"));
					cpsi.setUsuario(rs.getString("usuario"));
					
					lista.add(cpsi);
					
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
	
	public Contrato_proceso_seleccion_item Buscar(Contrato_proceso_seleccion_item o) throws Exception {
		
		 Connection cn = null;
		 
	        Contrato_proceso_seleccion_item cpsi = new Contrato_proceso_seleccion_item();
	        
	        try {
	            cn = DataAccess.getConnection();

	            String sql = " select "
	            		+ " id_contrato_proceso_seleccion_item, "
	            		+ " id_proceso_seleccion_item, "
						+ " date_format(fecha_adjudicacion, '%m/%d/%Y') as fecha_adjudicacion, "
						+ " monto_adjudicado, "
						+ " monto_pagado, "
						+ " porcentaje_pagado, "
						+ " contratista_adjudicado, "
						+ " ruc_contratista, "
						+ " numero_contrato, "
						+ " date_format(fecha_firma_contrato, '%m/%d/%Y') as fecha_firma_contrato, "
						+ " date_format(fecha_entrega_terreno, '%m/%d/%Y') as fecha_entrega_terreno, "
						+ " plazo_ejecucion, "
						+ " date_format(fecha_inicio_plazo_contractual, '%m/%d/%Y') as fecha_inicio_plazo_contractual, "
						+ " total_dias_ampliacion_plazo, "
						+ " total_adendas, "
						+ " monto_prestaciones_adicionales, "
						+ " observaciones, "
						+ " liquidacion "
	            		+ " from contrato_proceso_seleccion_item "
	            		+ " where id_contrato_proceso_seleccion_item = ? and activo = 1 ";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	                   	            
	            pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	cpsi.setId_contrato_proceso_seleccion_item(rs.getInt("id_contrato_proceso_seleccion_item"));
					cpsi.setId_proceso_seleccion_item(rs.getInt("id_proceso_seleccion_item"));
					cpsi.setFecha_adjudicacion(rs.getString("fecha_adjudicacion"));
					cpsi.setMonto_adjudicado(rs.getDouble("monto_adjudicado"));
					cpsi.setMonto_pagado(rs.getDouble("monto_pagado"));
					cpsi.setPorcentaje_pagado(rs.getDouble("porcentaje_pagado"));
					cpsi.setContratista_adjudicado(rs.getString("contratista_adjudicado"));
					cpsi.setRuc_contratista(rs.getString("ruc_contratista"));
					cpsi.setNumero_contrato(rs.getString("numero_contrato"));
					cpsi.setFecha_firma_contrato(rs.getString("fecha_firma_contrato"));
					cpsi.setFecha_entrega_terreno(rs.getString("fecha_entrega_terreno"));
					cpsi.setPlazo_ejecucion(rs.getInt("plazo_ejecucion"));
					cpsi.setFecha_inicio_plazo_contractual(rs.getString("fecha_inicio_plazo_contractual"));
					cpsi.setTotal_dias_ampliacion_plazo(rs.getInt("total_dias_ampliacion_plazo"));
					cpsi.setTotal_adendas(rs.getInt("total_adendas"));
					cpsi.setMonto_prestaciones_adicionales(rs.getDouble("monto_prestaciones_adicionales"));
					cpsi.setObservaciones(rs.getString("observaciones"));
					cpsi.setLiquidacion(rs.getString("liquidacion"));
					
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
	        return cpsi;	       	      
	}

}
