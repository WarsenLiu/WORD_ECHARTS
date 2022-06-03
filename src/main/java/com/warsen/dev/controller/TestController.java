package com.warsen.dev.controller;

import com.warsen.dev.util.ExportTemplateUtil;
import freemarker.template.Template;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Warsen Liu
 * @date 2022/6/2 21:36
 * @Version 1.0.0
 */
@RestController
public class TestController {

    @Resource
    ExportTemplateUtil exportTemplateUtil;

    @GetMapping
    public void testImportWord(HttpServletResponse response) {
        // 所有需要渲染到Word中的数据都需要put到此map中
        Map<String, Object> params = new HashMap<>();
        try {
            // wordVO 为需要填入模板的对象
            params.put("wordImporttitle", "这是一张图片");
            params.put("photoBase64", photoBase64);

            // 存放在template目录下的模板名，不带后缀！（例如：demo.ftl,此处填demo即可，多级目录加/即可）
            Template pointWork = exportTemplateUtil.localTemplate("demo");
            response.setContentType("application/msword; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=demo.doc");
            pointWork.process(params, new OutputStreamWriter(response.getOutputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String photoBase64 = "iVBORw0KGgoAAAANSUhEUgAAAjoAAAFRCAIAAADy8ZCTAAAAAXNSR0IArs4c6QAAAAlwSFlzAAAO\n" +
            "            xAAADsQBlSsOGwAAIshJREFUeF7t3X9oVff9x/H5/TLa2LFh0lAa52DLj3Y10kUS2do0stFGmCuB\n" +
            "            4pwJBrLA2kWZLcoYIaTrGsT5hwG7aWiRklVJNNscl2BhMWzTRCmrNHPRjObHylaMjNQ4tmnaMcj3\n" +
            "            1Xy+nO/93sTrvfece875nPM8f0hycs75vD+Pz4mvnM85995Vi4uLn2BBAAEEEEAg3AL/Fe7yqA4B\n" +
            "            BBBAAIGPBYgrzgMEEEAAAQsEVq04GTg5OWlB7ZSIAAIIIBA5gYqKihX7dMe4utMOkZOhQwgggAAC\n" +
            "            YRHQxdKd0ofJwLAMEnUggAACCKQRIK44PRBAAAEELBAgriwYJEpEAAEEECCuOAcQQAABBCwQIK4s\n" +
            "            GCRKRAABBBAgrjgHEEAAAQQsECCuLBgkSkQAAQQQIK44BxBAAAEELBAgriwYJEpEAAEEECCuOAcQ\n" +
            "            QAABBCwQIK4sGCRKRAABBBAgrjgHEMhRoKmpqaenZ25ubv/+/Xc6RG9v7+joaMpPtbKzs1M75tgw\n" +
            "            uyEQSwHiKpbDTqc9EtiwYcPf//73mZkZ5dbyQyqQzp8///7776/YWnFxsUdVcBgEYiHAO7LHYpjp\n" +
            "            ZD4EdHW1a9eu2traoaEhXTD96Ec/Ki8vT25IK5VkXV1dWqnLKX19pzLq6+tbWlryUSTHRMAugTTv\n" +
            "            yE5c2TWUVBsigd27dzc2NiquVNPY2FhVVVVycbq0+sEPftDe3q4M09fJ11LJMRai/lAKAiEQIK5C\n" +
            "            MAiUYK1A+guj5G6Vlpaaaykt3d3dhYWFumZSVr300ksNDQ1KqRUNkveyFonCEfBGgLjyxpGjxFNA\n" +
            "            caVEWT5Zp/XV1dXKoeUseryiv7//yJEjJrcWFhY6Ojqczbi6iueJRK8zEeDjGTNRYhsEVhYoKSlZ\n" +
            "            8Qdr1qy5efOm+VHyY36aGHz99de1l56/UKRduXJl+/bt4CKAgEsB7l25BGT36AuYSbzlV1fJ6xVL\n" +
            "            Sq+9e/caDj3avnbtWiXWyZMnn3rqqXXr1h09ejS9VF9fX/Qp6SECdxNgMvBuQvwcgTsLKJb07F/y\n" +
            "            z50HAkdGRszNKj0l+P3vfz/laQvNB05MTDh3szBGAIG7CjAZeFciNkAgnYAeNNfVj1l0H8tsqof9\n" +
            "            5ufn9YXCTJdWKVmlKcGzZ8/u2bPHOa6uwJRqy5flryNmMBBAYLkALxPmrEAgRwHlk+5dTU1N6e6U\n" +
            "            eZzdWXQr69ixY3V1dQot8x4W+kI/NbF3+PDh5eGXYxHshkBsBIir2Aw1Hc1VwFxCOUvyt+vXrx8e\n" +
            "            HlZcPfnkk8nbHD9+XEmmqy7NFuqxQD1AmHztdebMGb1mK9dy2A+BmAoQVzEdeLqduYCCR3N9zvb6\n" +
            "            9r777jPffuELX1Ag6Soq5R2Vnn76aT2aoUso3bhqa2tb/rB7TU1N5gWwJQIISIC44jRA4C4Cupwq\n" +
            "            KirSHaZEImHeGzDlNtWjjz6acgi9k4Xm/cxKzRZqPtBMBpplfHw8Of8YAAQQyESAuMpEiW3iK6Cw\n" +
            "            0eXUQw89dOPGjVOnTs3OzjpPtCu99DCFnrx48803nWQyX+jeleJNKbVv374f/vCHyqdPfepTmhIs\n" +
            "            KytTbl2/fl35p/lAbfPII4888MAD8fWl5whkLMDrrjKmYsNYCugVVAUFBc4LqhwDZZXSS9GlKy29\n" +
            "            x5IetdD7B+qRCsWPvlAUKeR0Z6uysvKxxx5zpgqVVT/5yU80ebh161bdwdLNLW2jFxGnvDduLKXp\n" +
            "            NAIfC/C6K84DBHIR0AundP1k3qbW2V+Rc/r06WvXrn3ve98zs4ImhHSZdfXqVfPqK6357Gc/a1JK\n" +
            "            V1pKJn2hXbRB8puv69LtjTfe0PodO3Y4k4e5FMo+CERFgNddRWUk6Ye/AqtXr9ZTEimXPsoh3Xly\n" +
            "            skoVKZ/0reYJlVgmwPSvc0WlL/TRIZoP1Dve6kNGkt8dQ0fWsxh67OLzn/+8vz2jNQTsE2Ay0L4x\n" +
            "            o2IEEEAgqgJcXUV1ZOkXAgggEBcBngyMy0jTTwQQQMBqAeLK6uGjeAQQQCAuAsRVXEaafiKAAAJW\n" +
            "            CxBXVg8fxSOAAAJxESCu4jLS9BMBBBCwWoC4snr4KB4BBBCIiwBxFZeRpp8IIICA1QLEldXDR/EI\n" +
            "            IIBAXASIq7iMNP1EAAEErBYgrqwePopHAAEE4iJAXMVlpOknAgggYLUAcWX18FE8AgggEBcB4iou\n" +
            "            I00/EUAAAasFiCurh4/iEUAAgbgIEFdxGWn6iQACCFgtkEtc6RO7Ozs7e3t7nZ739PQ0LS36ImVl\n" +
            "            a2urPkHcaiOKRwABBBAIXCCXuBoYGKiurnZKTyQSCwsLfX19hw8fnp6eHhsb04+Ghobm5+e15uDB\n" +
            "            g5cuXTIrWRBAAAEEEMhNIJe46ujoKCoqctpraGjYu3evvi0uLt6wYYNZPzMzs3nzZq3RsmXLlsuX\n" +
            "            L+dWH3shgAACCCAggVWLi4vLISYnJysqKtIAjY6O6kKqpaUleZu5ubkzZ86YlZot7OrqMj9dcePk\n" +
            "            HW8sLYwHAggggED0BHR5k3yFk76DadLHs7hSVg0PDzc2NppSsoqr6A0PPUIAAQQQyEEgTVzlMhm4\n" +
            "            vALdmkrOKm1QUlKiiyqzpa6c7rnnnhzqZhcEEEAAAQSMgAdxpeuqt956y7muMsfVTaxz587pR1rO\n" +
            "            nz+f/GgG9AgggAACCGQrkPVkoK6Zjh496jSza9eu999/f3Bw0FlTX19vbl/pofaRkZF7771Xz2Jo\n" +
            "            ybYytkcAAQQQiJuA9/eu4iZIfxFAAAEEfBDI+70rH/pAEwgggAACcRbw4N5VnPnoOwIIIICAPwLE\n" +
            "            lT/OtIIAAggg4EqAuHLFx84IIIAAAv4IEFf+ONMKAggggIArAeLKFR87I4AAAgj4I0Bc+eNMKwgg\n" +
            "            gAACrgSIK1d87IwAAggg4I8AceWPM60ggAACCLgSIK5c8bEzAggggIA/AsSVP860ggACCCDgSoC4\n" +
            "            csXHzggggAAC/ggQV/440woCCCCAgCsB4soVHzsjgAACCPgjQFz540wrCCCAAAKuBIgrV3zsjAAC\n" +
            "            CCDgjwBx5Y8zrSCAAAIIuBIgrlzxsTMCCCCAgD8CxJU/zrSCAAIIIOBKgLhyxcfOCCCAAAL+CBBX\n" +
            "            /jjTCgIIIICAKwHiyhUfOyOAAAII+CNAXPnjTCsIIIAAAq4EiCtXfOyMAAIIIOCPAHHljzOtIIAA\n" +
            "            Agi4EiCuXPGxMwIIIICAPwK5xNXU1FRnZ2dvb69TYk9PT1NTU2tra39/f/qV/vSKVhBAAAEEIiaQ\n" +
            "            S1wNDAxUV1c7EENDQ/Pz84cPHz548OClS5fGxsb0oxVXRsyO7iCAAAII+CaQS1x1dHQUFRU5Jc7M\n" +
            "            zGzevLl4admyZcvly5f1oxVX+tYrGkIAAQQQiJhALnGVQjA7O1tbW2tWrl692nyx4sqI2dEdBBBA\n" +
            "            AAHfBFYtLi4ub2xycrKioiJNEaOjo9PT0y0tLdpG97G6urrMxs76FVfe6YA3lhbf+kxDCCCAgCNw\n" +
            "            /4kdVmh8sPOkFXUuL1KzcckTcul7kSZ9PIgrPWexYcMGc4GVSCRu377d2Ni44kpLrSkbAQQiLDD/\n" +
            "            4kYrelf48jtW1OmyyDRx5cFkoLLq3Llzc0vL+fPnzVMYK6502Q12RwABBBCIrUDWV1ea7jt69Kjj\n" +
            "            tWvXLl1X6VpqZGTk3nvvbVhazE9XXBlbaDqOAALhFODqKlTj4v1kYKi6RzEIIIBAzgLEVc50+dgx\n" +
            "            v5OB+aiYYyKAAAIIIJAs4MG9K0ARQAABBBDItwBxlW9hjo8AAggg4IEAceUBIodAAAEEEMi3AHGV\n" +
            "            b2GOjwACCCDggQBx5QEih0AAAQQQyLcAcZVvYY6PAAIIIOCBAHHlASKHQAABBBDItwBxlW9hjo8A\n" +
            "            Aggg4IEAceUBIodAAAEEEMi3AHGVb2GOjwACCCDggQBx5QEih0AAAQQQyLcAcZVvYY6PAAIIIOCB\n" +
            "            QNYfIOJBmxE6xFP7LljRm7OHHreiTopEwH8B3pHdf/M0LfKO7KEaDopBAAEEEMhagMnArMnYAQEE\n" +
            "            EEDAfwHiyn9zWkQAAQQQyFqAuMqajB0QQAABBPwXIK78N6dFBBBAAIGsBYirrMnYAQEEEEDAfwHi\n" +
            "            yn9zWkQAAQQQyFqAuMqajB0QQAABBPwXIK78N6dFBBBAAIGsBYirrMnYAQEEEEDAfwHiyn9zWkQA\n" +
            "            AQQQyFqAuMqajB0QQAABBPwX8CauEolEa2trU1NTT0+P6YOzpru72/9e0SICCCCAQMQEPIirubm5\n" +
            "            oaGh9vb2vr6+hYUFBVXyGnn19/dHTI3uIIAAAgj4LOBBXL377rs1NTXl5eUqfdOmTTdv3hwbG3PW\n" +
            "            NDc3T0xM+NwrmkMAAQQQiJiAB3FVW1s7MzMzNTUlmt///vdlZWWzs7P610gVFxdHjIzuIIAAAgj4\n" +
            "            L+DNxzNqAvDUqVOqfv369R0dHb29vYorxZjpT2dnZ1dXV5q+3Vha/O+8+xZ3vzrn/iA+HOHIc1n8\n" +
            "            0XD/iR0+lOS+iQ92nnR/EI6AACd8vs+BoqUlw1bSfDyjB3Glqb8333zz2Wef1YWUbmLp0qqkpET/\n" +
            "            trS0qD5ddQ0MDCjDMqzVrs0i+WnCfLiqXSch1boU4IR3Cejt7vn9NGE9WJFc7rVr16qqqsbHx830\n" +
            "            4ODgYGVlpbf94WgIIIAAAnET8ODeVX19fWFh4fPPP68H2UdGRr7+9a/rMquuru7AgQNaU1BQ0NDQ\n" +
            "            EDdW+osAAggg4K2AB5OB3hZk19GYDAxwvApffifA1mk6MgJMBoZqKPM7GRiqrlIMAggggEAkBTyY\n" +
            "            DIykC51CAAEEEAiVAHEVquGgGAQQQACBlQWIK84MBBBAAAELBIgrCwaJEhFAAAEEiCvOAQQQQAAB\n" +
            "            CwSIKwsGiRIRQAABBIgrzgEEEEAAAQsEiCsLBokSEUAAAQSIK84BBBBAAAELBIgrCwaJEhFAAAEE\n" +
            "            iCvOAQQQQAABCwSIKwsGiRIRQAABBHhHdlfnAO/I7orP3c68I7s7v1z25oTPRc2jfWJywvOO7B6d\n" +
            "            LxwGAQQQQCAgASYDA4KnWQQQQACBbASIq2y02BYBBBBAICAB4iogeJpFAAEEEMhGgLjKRottEUAA\n" +
            "            AQQCEiCuAoKnWQQQQACBbASIq2y02BYBBBBAICAB4iogeJpFAAEEEMhGgLjKRottEUAAAQQCEiCu\n" +
            "            AoKnWQQQQACBbASIq2y02BYBBBBAICAB4iogeJpFAAEEEMhGwJu4Ghsb2717d1NTU2dn59zcnApI\n" +
            "            JBKtra1a093dnU09bIsAAggggMAKAt7E1bFjxxobG/v6+kpLSy9evKjEGhoaam9v1xq12d/fjz0C\n" +
            "            CCCAAAJuBDyIK11aKaVqa2tVR0tLS0NDg9bU1NSUl5drTXNz88TEhJsS2RcBBBBAAAEP4urWrVsL\n" +
            "            CwvJk4Gzs7NlZWUGt7i4GGUEEEAAAQRcCnjw8Yyjo6Oa7nvhhRd0OaUvrl+/XlhYqLgy11tadEOr\n" +
            "            q6srTaE3lhaXPQlk992vfnyjLvzLkeey+KPh/hM7wt8jVfjBzpNW1BmlIjnhAxxNe0/4oqUlQ7o0\n" +
            "            H8/oTVyNj4+3tbU54fTEE0/oAksTg1ozNTU1MDDQ0dGRYa12bcaHqwY4XjH5cNUAhZc3zQkf4HDE\n" +
            "            5ITP76cJ6ypqenpa96s0kL29vSUlJVVVVQowBZXWDA4OVlZWBjjGNI0AAgggEAEBD+5dSWHnzp16\n" +
            "            OFCPrc/MzGzbtk33q+rq6g4cOKA1BQUFevgiAlJ0AQEEEEAgQAEPJgMDrD7wppkbCXAIYjI3EqAw\n" +
            "            k4Ghwo/JCZ/fycBQjSjFIIAAAghEUsCbycBI0tApBBBAAIHwCBBX4RkLKkEAAQQQuKMAccXJgQAC\n" +
            "            CCBggQBxZcEgUSICCCCAAHHFOYAAAgggYIEAcWXBIFEiAggggABxxTmAAAIIIGCBAHFlwSBRIgII\n" +
            "            IIAAccU5gAACCCBggQBxZcEgUSICCCCAAHHFOYAAAgggYIEAcWXBIFEiAggggABxxTmAAAIIIGCB\n" +
            "            AHFlwSBRIgIIIIAAccU5gAACCCBggQBxZcEgUSICCCCAAHHFOYAAAgggYIEAcWXBIFEiAggggABx\n" +
            "            xTmAAAIIIGCBAHFlwSBRIgIIIIAAccU5gAACCCBggQBxZcEgUSICCCCAAHHFOYAAAgggYIEAcWXB\n" +
            "            IFEiAggggABxxTmAAAIIIGCBgJdx1d/f39nZaTqdSCRaW1ubmpq6u7stYKBEBBBAAIFwC3gWV1NT\n" +
            "            Ux999JHp7Nzc3NDQUHt7e19fn75VjIUbgeoQQAABBMIu4FlcDQ8Pb9261XR3bGyspqamvLxcXzc3\n" +
            "            N09MTISdgfoQQAABBMIt4E1caervy1/+cnFxsens7OxsWVmZ+dpZGW4HqkMAAQQQCLXAqsXFxeUF\n" +
            "            Tk5OVlRUZFi4pgHfe++9+vp6ba97V11dXb29vYqr2tpacwSzMs3RbiwtGTYXqs12vzoXqnruVMyR\n" +
            "            5/73L4lMqr3/xI5MNgt8mw92ngy8hrgVwAkf4Ijbe8IXLS0Z0qVJHw/iav/+/VevXk0upaWlRRdY\n" +
            "            +lcrFWYDAwMdHR0Z1mrXZk/tu2BFwWcPPZ55nfMvbsx84wC3LHz5nQBbj2fTnPABjntMTvg0ceXB\n" +
            "            ZKCiSI9UmKW0tFT/VlVVjY+PK6g0tIODg5WVlQGOMU0jgAACCERAwIO4Wq6g+1V1dXUHDhzQg+wF\n" +
            "            BQUNDQ0RkKILCCCAAAIBCngcV849KkXU66+/riuttra2ALtH0wgggAAC0RDwOK6igUIvEEAAAQTC\n" +
            "            JkBchW1EqAcBBBBAYAUB4orTAgEEEEDAAgHiyoJBokQEEEAAAeKKcwABBBBAwAIB4sqCQaJEBBBA\n" +
            "            AAHiinMAAQQQQMACAeLKgkGiRAQQQAAB4opzAAEEEEDAAgHiyoJBokQEEEAAAeKKcwABBBBAwAIB\n" +
            "            4sqCQaJEBBBAAAHiinMAAQQQQMACAeLKgkGiRAQQQAAB4opzAAEEEEDAAgHiyoJBokQEEEAAAeKK\n" +
            "            cwABBBBAwAIB4sqCQaJEBBBAAAHiinMAAQQQQMACAeLKgkGiRAQQQAAB4opzAAEEEEDAAgHiyoJB\n" +
            "            okQEEEAAAeKKcwABBBBAwAIB4sqCQaJEBBBAAAHiinMAAQQQQMACAeLKgkGiRAQQQAAB4opzAAEE\n" +
            "            EEDAAgFv4iqRSLS2tjY1NXV2ds7Nzanfzpru7m4LGCgRAQQQQCDcAh7E1dTU1Pnz5w8ePNjX17dm\n" +
            "            zZrh4WEl1tDQUHt7u9ao+/39/eFGoDoEEEAAgbALeBBX5eXlhw4dKi4uVl83bdqkf8fGxmpqarRe\n" +
            "            Xzc3N09MTISdgfoQQAABBMIt4EFcJXdwenr6ySefnJ2dLSsrM+tNjLEggAACCCDgRmDV4uLi8v0n\n" +
            "            JycrKiqyPa4m/ZRVyqfe3l7FVW1trTmCbmh1dXWlOdqNpSXb5sKw/e5XP75RF/7lyHNZ/NFw/4kd\n" +
            "            4e+RKvxg50kr6oxSkZzwAY6mvSd80dKSIV2a9PEmrnSz6syZM1u3bjXXUrpxpQuslpYWfa07WwMD\n" +
            "            Ax0dHRnWatdmT+27YEXBZw89nnmd8y9uzHzjALcsfPmdAFuPZ9Oc8AGOe0xO+DRx5c1k4C9+8Qsn\n" +
            "            qzScVVVV4+PjCip9PTg4WFlZGeAY0zQCCCCAQAQEPIgrPVgxMjLy/PPP60F28yy7rrHq6uoOHDig\n" +
            "            bwsKChoaGiIgRRcQQAABBAIU8GYyMMAOBNs0cyMB+sdkbiRA4eVNc8IHOBwxOeHzPhkY4BDSNAII\n" +
            "            IIBAHAQ8mAyMAxN9RAABBBAIVoC4Ctaf1hFAAAEEMhIgrjJiYiMEEEAAgWAFiKtg/WkdAQQQQCAj\n" +
            "            AeIqIyY2QgABBBAIVoC4Ctaf1hFAAAEEMhIgrjJiYiMEEEAAgWAFiKtg/WkdAQQQQCAjAeIqIyY2\n" +
            "            QgABBBAIVoC4Ctaf1hFAAAEEMhIgrjJiYiMEEEAAgWAFiKtg/WkdAQQQQCAjAeIqIyY2QgABBBAI\n" +
            "            VoC4Ctaf1hFAAAEEMhIgrjJiYiMEEEAAgWAFiKtg/WkdAQQQQCAjAeIqIyY2QgABBBAIVoC4Ctaf\n" +
            "            1hFAAAEEMhIgrjJiYiMEEEAAgWAFiKtg/WkdAQQQQCAjAeIqIyY2QgABBBAIVoC4Ctaf1hFAAAEE\n" +
            "            MhIgrjJiYiMEEEAAgWAFiKtg/WkdAQQQQCAjAeIqIyY2QgABBBAIViBfcTU2NrZ79+6mpqbOzs6p\n" +
            "            qalgO0nrCCCAAAK2C+Qrrk6cONHY2NjX11ddXT0wMGA7E/UjgAACCAQrkJe4mpubW716dW1trfrW\n" +
            "            0NAwPz8fbCdpHQEEEEDAdoG8xNW7775bWlrq0Ci6bGeifgQQQACBYAVWLS4uLq9gcnKyoqIi58pG\n" +
            "            R0enp6dbWlrMEXT7qqurK83RbiwtOTfHjggggAACoRUoWloyLC9N+uQlrjQZ+MorrzgRtW/fvkOH\n" +
            "            DmVYK5shgAACCMRWIE1c5WUysLi4WNa6xtK/iURi7dq1saWn4wgggAACngjkJa5U2TPPPNPf368H\n" +
            "            2S9dutTc3OxJrRwEAQQQQCC2AnmZDIytJh1HAAEEEHAj4PdkoJta2RcBBBBAAIHlAvmaDMQaAQQQ\n" +
            "            QAABDwWIKw8xORQCCCCAQL4EiKt8yXJcBBBAAAEPBYgrDzE5FAIIIIBAvgSIq3zJhuG4+/fv11vj\n" +
            "            q5Lu7u7e/7+Y9clLT0/P8pVh6AU1IJChgDmB9TY6+ndoaMic+XrXguTd9a3ZTC8JNdto0S8HJ3+G\n" +
            "            yAFuRlwFiJ/3prdv33769Gl9gMvevXv1nljXrl3Tv2apqqpKaX7btm16H33nFzjvxdEAAl4LvPXW\n" +
            "            W+bjivS3l3mzAi3OF05r+qVQOD322GO//vWvlV7aZWZmZvlvhNfVcTy3Arzuyq1gyPfXb6N+XfWS\n" +
            "            7Y8++ki/k+ath9esWaN3yjd/YF65cuXDDz80vbh9+7b+dd6SWBs7b/wY8m5SHgI6mW/evCmHt99+\n" +
            "            u6amRh8EoRNYp7d5Vx19qz/ajJLy6Y033tC7xJkrqt/+9rdPP/10eXk5hmEQ8Ps9A8PQZ2rQNEhh\n" +
            "            YaEcTOQ47zus39ULFy4k55CuqGZnZ501mkJ89tlnl/9NCikCIRcw71aqWQT9Nfa5z31OV1HmnUt1\n" +
            "            Snd0dOgL5dPly5dTemHiTSvLysrMxx6xBCjAy4QDxA+saTMBqCsqpwL9Nurrv/3tbyk11dfXj4+P\n" +
            "            myl+8y9ZFdiw0XCuAiar9PZvupzSPIFi6YknnlA+aXHetvTWrVs6fElJSXIjyiqtMb8dLGEW+O+X\n" +
            "            XnppeX36OI/M3+89zN2jNk10/POf/9Scvv6E1HyIPopMn+2ia6k//OEPX/nKVxwfzQf+8Y9//NKX\n" +
            "            vvTzn/9848aN+ssUOgTsEhgeHtbsn4Lqk5/8pN6nVCfz9evX//znP2uNphnMNLj+Z/v3v/+9detW\n" +
            "            /dQsv/nNbxYWFnbu3KkfaTP+3wt80NOkD3EV+OjktwDF0re//e377rvvX//6V0FBgRrTv/q1bGtr\n" +
            "            S2744Ycf/uUvf6lg09WYfnXzWxNHRyAPAvqbTCfwxYsXP/3pT1+9evUvf/mLpg0GBgaURlu2bNGv\n" +
            "            gNp88MEHdao7jeuJjP/85z/mnpZ+RFblYViyPiRxlTVZZHbQ5ZQ+gVO3oHVppblB8xelkulrX/ta\n" +
            "            Sh/XrVv305/+VH94Jn8SdGQc6EjkBXRi628yXVp95zvf0TWT7kIpfv76179qLuEb3/iG6b4eWNcf\n" +
            "            cMmL5gCdb//0pz9t2LAh8lAh7yBxFfIByld5ms3/3e9+p/tSmprXH576fTYtaYYwJa40v3/y5MnG\n" +
            "            xkb9cao71fzS5mtIOG4+BXQa67pK8aMpBF1Rqanjx48rwPQorC6e9K0zB2i+0C+I8zecvuW0z+fg\n" +
            "            ZHps4ipTqYhtZ+4z69Oc//GPf+jelf7SNH9IasZPV1Gms3pQ8Gc/+5k227Nnzxe/+MW6ujo9+6s/\n" +
            "            QnU1pnkS80vOgoAVApro05NEusZSDimijh49qhu0ekGhzmedzMunDfS74PwNZ0UH41BkmrjidVdx\n" +
            "            OAH+7yl201u97N884Kun2/VKSf0dmvL8rn7bdZmlDczLs1gQCL+AeTVVdXW1TlqdwK+99poe+dPt\n" +
            "            K1Wub8+cOaM/0ZxHXs1jhIo058VY4e9gTCrkdVcxGWi6iQACCNgtwOuu7B4/qkcAAQQQ4D0DOQcQ\n" +
            "            QAABBCwQIK4sGCRKRAABBBAgrjgHEEAAAQQsECCuLBgkSkQAAQQQIK44BxBAAAEELBAgriwYJEpE\n" +
            "            AAEEECCuOAcQQAABBCwQIK4sGCRKRAABBBAgrjgHEEAAAQQsECCuLBgkSkQAAQQQIK44BxBAAAEE\n" +
            "            LBAgriwYJEpEAAEEECCuOAcQQAABBCwQIK4sGCRKRAABBBAgrjgHEPiEPky5p6dHnznb3d0tDn1q\n" +
            "            pb42LvraN6Dkdn1rlIYQsEWATxO2ZaSo0w8B8znLio3p6emWlhbF2OnTp/fs2WM+hTaRSFy6dGnF\n" +
            "            Op555pmqqqocSlRMzs7Omh1v37794YcfFhYWmm9LSkra2tpMuzdv3lzx4NrGfGAuCwLREODThKMx\n" +
            "            jvTCrcBT+y6kHOLsoceT1yTH1aOPPpqcVW7ann9xY8ruhS+/k7xGn8V+/PhxrVlYWFBiOQFpttGl\n" +
            "            XllZWW1trb5QiDrfmis/rXdTG/siECoBPk04VMNBMWEUUAZomZ+fd4q7fPlySmzkqW6lziuvvPLV\n" +
            "            r35106ZNa9eu1YWavtUVlTIspcXk8vJUDIdFILQC3LsK7dBQmK8CMzMzunA5cuSIcuJXv/rV22+/\n" +
            "            rTWKDV1vaXFK0dydWZO8aJfcap2amtq3b9/4+LhyUXOJDzzwgK6i9IUmJHXAH//4xyl3zu40JZhb\n" +
            "            6+yFgF0C3Luya7yo1pVAmslAMw1ojm7uXd1zzz3r1q3zZKotzWSgLqEuXryYcktMd6S2bdtmbphp\n" +
            "            MbN/Dz300GuvvdbR0cFkoKuTgJ3DLcBkYLjHh+qCFlBmaJ5NMaCLJz1eYcp5+OGHdd2T79KUSQ0N\n" +
            "            DUpKLbrGeuSRR0pLS5OzyhRw48YNZdXmzZv1taLr3Llzylc9mpHv8jg+AuER4OoqPGNBJXkXuOuj\n" +
            "            FkosPWFx69Yt82Tg/v37t2/fXl5e7rKyNFdXyTONKU8GqlFzwWcup/RFyqUej1q4HBd2D6EATwaG\n" +
            "            cFAoKYwCet3V3r17zWSgcksl6uFA85C6eag9TdE5P8vuHNN5gD6lFfMMiPOAu/NTrdTTGZ5MV4Zx\n" +
            "            MKgplgLEVSyHnU5nL+A8yK6nLVavXq2LG6XUsWPHXnjhBffXWHctJ01cmQfZU46g2nQhSFzdFZYN\n" +
            "            LBIgriwaLEoNRkBP92mpqanRK3MVG7prZV6i69uiSyg1umXLFl7265s5DYVQgLgK4aBQEgIIIIBA\n" +
            "            qgBPBnJOIIAAAgjYLcDLhO0eP6pHAAEEYiJAXMVkoOkmAgggYLcAcWX3+FE9AgggEBMB4iomA003\n" +
            "            EUAAAVsFhoeHVTpxZev4UTcCCCAQVYErS4vTO71sn7iK6ljTLwQQQMBWgffee0+vfXzwwQdTOsDV\n" +
            "            la0jSt0IIIBAJAWUVd/85jeLiopSesdb3EZyuOkUAgggYKWAXibc39+fUro+Cu673/0ucWXliFI0\n" +
            "            AgggEEkBxZXeDPNb3/rW8t4xGRjJEadTCCCAgK0C69evP3Xq1PLq73h1ZWtHqRsBBBBAwGaBiooK\n" +
            "            Pbn+mc98Rm85ndyPlePK5p5SOwIIIIBABAWYDIzgoNIlBBBAIHoCxFX0xpQeIYAAAhEUIK4iOKh0\n" +
            "            CQEEEIieAHEVvTGlRwgggEAEBYirCA4qXUIAAQSiJ0BcRW9M6RECCCAQQQHiKoKDSpcQQACB6AkQ\n" +
            "            V9EbU3qEAAIIRFCAuIrgoNIlBBBAIHoC/wP06EjdbK394AAAAABJRU5ErkJggg==";

}
