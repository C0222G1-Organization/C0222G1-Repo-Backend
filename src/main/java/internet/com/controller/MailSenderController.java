package internet.com.controller;

import internet.com.dto.reponse_body.ReponseBody;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("/mail")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MailSenderController {
    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/send")
    public ResponseEntity<String> sendSimpleEmail (@RequestBody ReponseBody reponseBody) throws MessagingException {
//        this.emailSender.send(message);
        ReponseBody reponseBodyNew = modelMapper.map(reponseBody , ReponseBody.class);
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;
        MimeMessageHelper helper = new MimeMessageHelper(message , multipart , "utf-8");
        String htmlMsg = "<div style=\"background: url('https://images2.alphacoders.com/401/thumb-1920-40102.jpg') white; background-size: 100% 100%; background-position:right; min-height: 800px; background-repeat: no-repeat;\">" +
                "<p>Dear <b>" + reponseBodyNew.getFullName() + "</b>,</p>\n" +
                "<p>Thank you for using our service. C02G1 would like to send you the payment invoice.</p>\n" +
                "<p>Please check the information below. For more information, please contact phone number: 0969.307.886 (Mr. Luan - Accounting).</p>\n" +
                "<table class=\"table\" style=\"border: 1px solid; padding: 10px 10px; border-collapse: collapse;\">\n" +
                "  <thead>\n" +
                "  <tr style=\"background-color: antiquewhite;\">\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Code Payment</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Status</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Total</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Email</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Full Name</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Address</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">City</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Province</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Zipcode</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Nation</th>\n" +
                "  </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" +
                "  <tr>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + reponseBodyNew.getId() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Hoàn thành</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + reponseBodyNew.getValue() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + reponseBodyNew.getEmail() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + reponseBodyNew.getFullName() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + reponseBodyNew.getAddress() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + reponseBodyNew.getArea1() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + reponseBodyNew.getArea2() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + reponseBodyNew.getPostalCode() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + reponseBodyNew.getCountryCode() + "</td>\n" +
                "  </tr>\n" +
                "  </tbody>\n" +
                "</table>" +
                "<p style=\"font-size: 11px; color: aqua;\"><i>Thanks and best regards</i></p>\n" +
                "<p style=\"font-size: 11px; color: aqua;\">_____________________________</p>\n" +
                "<p style=\"font-size: 11px; color: aqua;\"><i>Nguyen Dinh Luan ( Mr.) - Accounting.</i></p>\n" +
                "<p style=\"font-size: 11px; color: aqua;\"><i>Phone: 0969.307.886.</i></p>\n" +
                "<p style=\"font-size: 11px; color: aqua;\"><i>Email: luanqn20@gmail.com.</i></p>\n" +
                "</div>";
        message.setContent(htmlMsg , "text/html");
        helper.setTo("luanqn20@gmail.com");
        helper.setSubject("Payment Successfully!");
        this.emailSender.send(message);

        return new ResponseEntity<>("Email Sent!" , HttpStatus.OK);
    }
}
