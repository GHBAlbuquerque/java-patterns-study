package com.patterns.domain.strategy.entity;

import com.patterns.domain.entity.Agreement;
import com.patterns.domain.enums.EntityEnum;

public class InvoiceDetailsStrategy extends Middleware {

    @Override
    protected EntityEnum getEntityEnum() {
        return EntityEnum.INVOICE;
    }

    @Override
    public void handle(Agreement.Builder builder, String acordoId) {
        // ---- TODO ----
    }

    /*@Component
@RequiredArgsConstructor
@Slf4j
public class DetalharContratosStrategy extends Middleware {

    private final BackContratoBaixaClient backContratoBaixaClient;
    private final DetalheContratoResponseMapper detalheContratoResponseMapper;

    @Override
    public void handle(final AcordoDetalhadoResponse.Builder builder, final String acordoId) {
        try {
            final List<ContratoBaixaResponse> contratos = backContratoBaixaClient.buscarContratoBaixaPorId(acordoId, NUMERO_PAGAMENTO_PADRAO);

            for (final ContratoBaixaResponse contrato : contratos) {
                builder.adicionarContrato(detalheContratoResponseMapper.getDetalheContratoResponse(contrato));
            }

            getNext().ifPresent(handler -> handler.handle(builder, acordoId));

        } catch (FeignException.NotFound ex) {
            log.warn("Contratos não encontrados para acordo: {}", acordoId, ex);
        } catch (FeignException ex) {
            log.error("Erro no serviço externo ao buscar contratos para acordo: {}", acordoId, ex);
        } catch (Exception ex) {
            log.error("Erro inesperado ao processar contratos para acordo: {}", acordoId, ex);
        }
    }

    @Override
    protected EntidadeEnum getEntidadeEnum() {
        return EntidadeEnum.CONTRATOS_BAIXA;
    }
}
*/
}
