package allAround.model;

public class Completion {
    protected int completionid;
    protected int year;
    protected String completionratesuppressedoverall1;
    protected String completionratesuppressedoverall2;
    protected String completionrate4yr150nt;
    protected String completionratelessthan4yr150nt;
    protected Schools school;
    
    public Completion(int completionid, int year, String completionratesuppressedoverall1,
            String completionratesuppressedoverall2, String completionrate4yr150nt,
            String completionratelessthan4yr150nt, Schools school) {
        super();
        this.completionid = completionid;
        this.year = year;
        this.completionratesuppressedoverall1 = completionratesuppressedoverall1;
        this.completionratesuppressedoverall2 = completionratesuppressedoverall2;
        this.completionrate4yr150nt = completionrate4yr150nt;
        this.completionratelessthan4yr150nt = completionratelessthan4yr150nt;
        this.school = school;
    }

    public Completion(int year, String completionratesuppressedoverall1,
            String completionratesuppressedoverall2, String completionrate4yr150nt,
            String completionratelessthan4yr150nt, Schools school) {
        super();
        this.year = year;
        this.completionratesuppressedoverall1 = completionratesuppressedoverall1;
        this.completionratesuppressedoverall2 = completionratesuppressedoverall2;
        this.completionrate4yr150nt = completionrate4yr150nt;
        this.completionratelessthan4yr150nt = completionratelessthan4yr150nt;
        this.school = school;
    }

    public int getCompletionid() {
        return completionid;
    }

    public void setCompletionid(int completionid) {
        this.completionid = completionid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCompletionratesuppressedoverall1() {
        return completionratesuppressedoverall1;
    }

    public void setCompletionratesuppressedoverall1(String completionratesuppressedoverall1) {
        this.completionratesuppressedoverall1 = completionratesuppressedoverall1;
    }

    public String getCompletionratesuppressedoverall2() {
        return completionratesuppressedoverall2;
    }

    public void setCompletionratesuppressedoverall2(String completionratesuppressedoverall2) {
        this.completionratesuppressedoverall2 = completionratesuppressedoverall2;
    }

    public String getCompletionrate4yr150nt() {
        return completionrate4yr150nt;
    }

    public void setCompletionrate4yr150nt(String completionrate4yr150nt) {
        this.completionrate4yr150nt = completionrate4yr150nt;
    }

    public String getCompletionratelessthan4yr150nt() {
        return completionratelessthan4yr150nt;
    }

    public void setCompletionratelessthan4yr150nt(String completionratelessthan4yr150nt) {
        this.completionratelessthan4yr150nt = completionratelessthan4yr150nt;
    }

    public Schools getSchool() {
        return school;
    }

    public void setSchool(Schools school) {
        this.school = school;
    }
    
    
    
}
