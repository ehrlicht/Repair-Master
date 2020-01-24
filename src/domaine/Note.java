/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;

import java.util.Date;

/**
 *
 * @author Hourglass
 */
public class Note {
    
    private Date date;
    private String title;
    private String body;
    private int repId;

    public Note(Date date, String title, String body, int repId) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.repId = repId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getRepId() {
        return repId;
    }

    public void setRepId(int repId) {
        this.repId = repId;
    }
    
}
