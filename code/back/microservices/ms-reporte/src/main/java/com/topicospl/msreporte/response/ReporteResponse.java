package com.topicospl.msreporte.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReporteResponse {

	private String code;
	private String status;
	private String message;
}
