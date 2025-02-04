package com.agumon.mail.model;

import com.beust.jcommander.internal.Sets;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.helpers.mail.objects.Attachments;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Map;
import java.util.Set;

public class MailRequest {

    @JsonProperty("from")
    private String from;

    @JsonProperty("fromName")
    private String fromName;

    @JsonProperty("to")
    private String to;

    @JsonProperty("to_mails")
    private Set<String> toMails;

    @JsonProperty("toName")
    private String toName;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("content")
    private String content;

    @JsonProperty("attachments")
    private Attachments attachments;

    @JsonProperty("dynamic_template_data")
    private Map<String, Object> data;

    @JsonProperty("template_id")
    private String templateId;

    @JsonProperty("mail_type")
    private EmailType emailType;

    private String token;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
        this.toMails = CollectionUtils.isEmpty(this.toMails) ? Sets.newHashSet() : this.toMails;
        this.toMails.add(this.to);
    }

    public Set<String> getToMails() {
        return toMails;
    }

    public void setToMails(Set<String> toMails) {
        this.toMails = toMails;
        if (this.to != null) {
            this.toMails.add(this.to);
        }
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachments getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachments attachments) {
        this.attachments = attachments;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public EmailType getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
