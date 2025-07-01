package com.patterns.domain.strategy.entity;

import com.patterns.domain.entity.Agreement;
import com.patterns.domain.enums.EntityEnum;

public class AgreementDetailsStrategy extends Middleware {

    @Override
    protected EntityEnum getEntityEnum() {
        return EntityEnum.AGREEMENT;
    }

    @Override
    public void handle(Agreement.Builder builder, String acordoId) {
        // ---- TODO ----
    }

    /*@Component
@RequiredArgsConstructor
@Slf4j
public class DetalharAcordoStrategy extends Middleware {

    private final BackAcordoCobrancaClient backAcordoCobrancaClient;
    private final BackPagamentoClient backPagamentoClient;
    private final DetaAcordoResponseMapper detaAcordoResponseMapper;

    @Override
    public void handle(final AcordoDetalhadoResponse.Builder builder, final String acordoId) {
        CompletableFuture<AcordoCobrancaResponseEstendido> acordoCobrancaFuture =
            CompletableFuture.supplyAsync(() -> backAcordoCobrancaClient.buscarAcordoPorId(acordoId, NUMERO_PAGAMENTO_PADRAO));

        CompletableFuture<PagamentoResponsePaginado> pagamentoFuture =
            CompletableFuture.supplyAsync(() -> backPagamentoClient.buscarPagamentoPorId(acordoId));

        try {
            AcordoCobrancaResponseEstendido acordoCobrancaResponseEstendido = acordoCobrancaFuture.get();
            PagamentoResponsePaginado pagamentoResponsePaginado = pagamentoFuture.get();

            BigDecimal valorPagtoTituloCobranca = pagamentoResponsePaginado.getPagamentos().stream()
                .map(PagamentoResponse::getValorPagamento)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

            builder.acordo(detaAcordoResponseMapper.getDetalheAcordoResponse(acordoCobrancaResponseEstendido));
            builder.valorPagtoTituloCobranca(valorPagtoTituloCobranca);

            getNext().ifPresent(handler -> handler.handle(builder, acordoId));

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            log.error("Thread interrompida ao processar acordo: {}", acordoId, ex);
        } catch (ExecutionException ex) {
            log.error("Erro na execução assíncrona ao processar acordo: {}", acordoId, ex);
        } catch (FeignException ex) {
            log.error("Erro no serviço externo ao processar acordo: {}", acordoId, ex);
        } catch (Exception ex) {
            log.error("Erro inesperado ao processar acordo: {}", acordoId, ex);
        }
    }

    @Override
    protected EntidadeEnum getEntidadeEnum() {
        return EntidadeEnum.ACORDO;
    }
}
*/

}
