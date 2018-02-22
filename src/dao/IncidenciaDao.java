package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Incidencia;

public class IncidenciaDao implements Intermetodos<Incidencia>{

	@Override
	public void Grabar(Incidencia o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = " insert into incidencia("
					+ " id_contrato_proceso_seleccion_item, "
					+ " detalle_incidencia, "
					+ " motivo, "
					+ " asiento_cuaderno_obra, "
					+ " fecha_evento, "
					+ " fecha_asiento, "
					+ " acciones, "
					+ " documento_emitido, "
					+ " sumilla, "
					+ " objeto_incidencia, "
					+ " usuario, "
					+ " fecha_registro, "					
					+ " activo) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
			pstm.setString(2, o.getDetalle_incidencia());
			pstm.setString(3, o.getMotivo());
			pstm.setString(4, o.getAsiento_cuaderno_obra());
			pstm.setString(5, o.getFecha_evento());
			pstm.setString(6, o.getFecha_asiento());
			pstm.setString(7, o.getAcciones());
			pstm.setString(8, o.getDocumento_emitido());
			pstm.setString(9, o.getSumilla());
			pstm.setString(10, o.getObjeto_incidencia());
			pstm.setString(11, o.getUsuario());
			
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
	public void Eliminar(Incidencia o) throws Exception {
		
		Connection cn = null;
		
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update incidencia set activo = 0, fecha_ultima_modificacion = sysdate() where id_incidencia = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_incidencia());
			
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
	public void Modificar(Incidencia o) throws Exception {
		
	Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update incidencia  set "				
					+ " detalle_incidencia = ?, "
					+ " motivo = ?, "
					+ " asiento_cuaderno_obra = ?, "
					+ " fecha_evento = ?, "
					+ " fecha_asiento = ?, "
					+ " acciones = ?,"
					+ " documento_emitido = ?, "
					+ " sumilla = ?, "
					+ " objeto_incidencia = ?, "
					+ " usuario = ?,"					
					+ " fecha_ultima_modificacion = sysdate() "
					+ " where id_incidencia = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getDetalle_incidencia());
			pstm.setString(2, o.getMotivo());
			pstm.setString(3, o.getAsiento_cuaderno_obra());
			pstm.setString(4, o.getFecha_evento());
			pstm.setString(5, o.getFecha_asiento());
			pstm.setString(6, o.getAcciones());
			pstm.setString(7, o.getDocumento_emitido());
			pstm.setString(8, o.getSumilla());
			pstm.setString(9, o.getObjeto_incidencia());
			pstm.setString(10, o.getUsuario());
			
			pstm.setInt(11, o.getId_incidencia());
						
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
	public List<Incidencia> Listar() throws Exception {
		
		return null;
	}

	@Override
	public List<Incidencia> Filtrar(Incidencia o) throws Exception {
		
		 Connection cn = null;
	        List<Incidencia> lista = new ArrayList<Incidencia>();
	        try {
	           
	            cn = DataAccess.getConnection();
	   
	            String sql ="select "
	            		+ " id_incidencia, "
	            		+ " id_contrato_proceso_seleccion_item, "
	            		+ " detalle_incidencia, "
	            		+ " motivo, "
	            		+ " asiento_cuaderno_obra, "
	            		+ " fecha_evento, "
	            		+ " fecha_asiento, "
	            		+ " acciones, "
	            		+ " documento_emitido, "
	            		+ " sumilla, "
	            		+ " objeto_incidencia, "	            	
	            		+ " usuario "
	            		+ "   from incidencia "
	            		+ " where id_contrato_proceso_seleccion_item = ? "
	            		+ " and activo = 1 order by id_incidencia asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
	           
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Incidencia i = new Incidencia();
		
					i.setId_incidencia(rs.getInt("id_incidencia"));
					i.setId_contrato_proceso_seleccion_item(rs.getInt("id_contrato_proceso_seleccion_item"));
					i.setDetalle_incidencia(rs.getString("detalle_incidencia"));
					i.setMotivo(rs.getString("motivo"));
					i.setAsiento_cuaderno_obra(rs.getString("asiento_cuaderno_obra"));
					i.setFecha_evento(rs.getString("fecha_evento"));
					i.setFecha_asiento(rs.getString("fecha_asiento"));
					i.setAcciones(rs.getString("acciones"));
					i.setDocumento_emitido(rs.getString("documento_emitido"));
					i.setSumilla(rs.getString("sumilla"));
					i.setObjeto_incidencia(rs.getString("objeto_incidencia"));
				
					i.setUsuario(rs.getString("usuario"));
					
					lista.add(i);
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
	        return lista;
	}

	@Override
	public Incidencia Buscar(Incidencia o) throws Exception {
		Connection cn = null;
		
        Incidencia i = new Incidencia();
        
        try {
            cn = DataAccess.getConnection();

            String sql = " select "
            		+ " id_incidencia, "            		
            		+ " detalle_incidencia, "
            		+ " motivo, "
            		+ " asiento_cuaderno_obra, "
            		+ " date_format(fecha_evento, '%m/%d/%Y') as  fecha_evento, "
            		+ " fecha_asiento, "
            		+ " acciones, "
            		+ " documento_emitido, "
            		+ " sumilla, "
            		+ " objeto_incidencia "
            		+ "   from incidencia "
            		+ " where id_incidencia = ? "
            		+ " and activo = 1";

            PreparedStatement pstm = cn.prepareStatement(sql);
            
            pstm.setInt(1, o.getId_incidencia());
            
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

            	i.setId_incidencia(rs.getInt("id_incidencia"));
				i.setDetalle_incidencia(rs.getString("detalle_incidencia"));
				i.setMotivo(rs.getString("motivo"));
				i.setAsiento_cuaderno_obra(rs.getString("asiento_cuaderno_obra"));
				i.setFecha_evento(rs.getString("fecha_evento"));
				i.setFecha_asiento(rs.getString("fecha_asiento"));
				i.setAcciones(rs.getString("acciones"));
				i.setDocumento_emitido(rs.getString("documento_emitido"));
				i.setSumilla(rs.getString("sumilla"));
				i.setObjeto_incidencia(rs.getString("objeto_incidencia"));
				

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
        return i;
	}

}
