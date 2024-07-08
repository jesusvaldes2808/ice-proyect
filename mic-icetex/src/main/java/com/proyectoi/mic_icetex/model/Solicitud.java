package com.proyectoi.mic_icetex.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Solicitudes")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solicitud_id")
    private Integer solicitudId;

    @Column(name = "correo")
    private String correo;

    @Column(name = "correoaux")
    private String correoAux;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "estado2", length = 50)
    private String estadoDos;

    @Column(name = "clave_documentos", length = 100)
    private String claveDocumentos;

    @Column(name = "clave_portal", length = 100)
    private String clavePortal;

    @Column(name = "clave_correo", length = 100)
    private String claveCorreo;

    @Column(name = "anotacion")
    private String anotacion;

    @Column(name = "precio_cobrado")
    private Double precioCobrado;

    @Column(name = "abono")
    private Double abono;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;


}
