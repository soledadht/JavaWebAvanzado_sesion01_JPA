package com.tecsup.javawebavanzado.sesion01.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_pedido database table.
 * 
 */
@Embeddable
public class DetallePedidoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="iddetalle_pedido")
	private int iddetallePedido;

	@Column(insertable=false, updatable=false)
	private int idpedido;

	public DetallePedidoPK() {
	}
	public int getIddetallePedido() {
		return this.iddetallePedido;
	}
	public void setIddetallePedido(int iddetallePedido) {
		this.iddetallePedido = iddetallePedido;
	}
	public int getIdpedido() {
		return this.idpedido;
	}
	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallePedidoPK)) {
			return false;
		}
		DetallePedidoPK castOther = (DetallePedidoPK)other;
		return 
			(this.iddetallePedido == castOther.iddetallePedido)
			&& (this.idpedido == castOther.idpedido);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.iddetallePedido;
		hash = hash * prime + this.idpedido;
		
		return hash;
	}
}