package beans;

import javax.servlet.http.HttpSession;

public class Statistica {

	private int min;
	private int ast;
	private int pts;
	private int fgm;
	private int fga;
	private double fg_perc;
	private int three_pm;
	private int three_pa;
	private double three_p_perc;
	private int two_pm;
	private int two_pa;
	private double two_p_perc;
	private int ftm;
	private int fta;
	private double ft_perc;
	private int blk;
	private int stl;
	private int tov;
	private int pf;
	private HttpSession session;
	
	
	public Statistica(int min, int ast, int pts, int fgm, int fga, double fg_perc, int three_pm, int three_pa,
			double three_p_perc, int two_pm, int two_pa, double two_p_perc, int ftm, int fta, double ft_perc, int blk,
			int stl, int tov, int pf) {
		super();
		this.min = min;
		this.ast = ast;
		this.pts = pts;
		this.fgm = fgm;
		this.fga = fga;
		this.fg_perc = fg_perc;
		this.three_pm = three_pm;
		this.three_pa = three_pa;
		this.three_p_perc = three_p_perc;
		this.two_pm = two_pm;
		this.two_pa = two_pa;
		this.two_p_perc = two_p_perc;
		this.ftm = ftm;
		this.fta = fta;
		this.ft_perc = ft_perc;
		this.blk = blk;
		this.stl = stl;
		this.tov = tov;
		this.pf = pf;
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public int getAst() {
		return ast;
	}


	public void setAst(int ast) {
		this.ast = ast;
	}


	public int getPts() {
		return pts;
	}


	public void setPts(int pts) {
		this.pts = pts;
	}


	public int getFgm() {
		return fgm;
	}


	public void setFgm(int fgm) {
		this.fgm = fgm;
	}


	public int getFga() {
		return fga;
	}


	public void setFga(int fga) {
		this.fga = fga;
	}


	public double getFg_perc() {
		return fg_perc;
	}


	public void setFg_perc(double fg_perc) {
		this.fg_perc = fg_perc;
	}


	public int getThree_pm() {
		return three_pm;
	}


	public void setThree_pm(int three_pm) {
		this.three_pm = three_pm;
	}


	public int getThree_pa() {
		return three_pa;
	}


	public void setThree_pa(int three_pa) {
		this.three_pa = three_pa;
	}


	public double getThree_p_perc() {
		return three_p_perc;
	}


	public void setThree_p_perc(double three_p_perc) {
		this.three_p_perc = three_p_perc;
	}


	public int getTwo_pm() {
		return two_pm;
	}


	public void setTwo_pm(int two_pm) {
		this.two_pm = two_pm;
	}


	public int getTwo_pa() {
		return two_pa;
	}


	public void setTwo_pa(int two_pa) {
		this.two_pa = two_pa;
	}


	public double getTwo_p_perc() {
		return two_p_perc;
	}


	public void setTwo_p_perc(double two_p_perc) {
		this.two_p_perc = two_p_perc;
	}


	public int getFtm() {
		return ftm;
	}


	public void setFtm(int ftm) {
		this.ftm = ftm;
	}


	public int getFta() {
		return fta;
	}


	public void setFta(int fta) {
		this.fta = fta;
	}


	public double getFt_perc() {
		return ft_perc;
	}


	public void setFt_perc(double ft_perc) {
		this.ft_perc = ft_perc;
	}


	public int getBlk() {
		return blk;
	}


	public void setBlk(int blk) {
		this.blk = blk;
	}


	public int getStl() {
		return stl;
	}


	public void setStl(int stl) {
		this.stl = stl;
	}


	public int getTov() {
		return tov;
	}


	public void setTov(int tov) {
		this.tov = tov;
	}


	public int getPf() {
		return pf;
	}


	public void setPf(int pf) {
		this.pf = pf;
	}


	public HttpSession getSession() {
		return session;
	}


	public void setSession(HttpSession session) {
		this.session = session;
	}


	@Override
	public String toString() {
		return "Statistica [min=" + min + ", ast=" + ast + ", pts=" + pts + ", fgm=" + fgm + ", fga=" + fga
				+ ", fg_perc=" + fg_perc + ", three_pm=" + three_pm + ", three_pa=" + three_pa + ", three_p_perc="
				+ three_p_perc + ", two_pm=" + two_pm + ", two_pa=" + two_pa + ", two_p_perc=" + two_p_perc + ", ftm="
				+ ftm + ", fta=" + fta + ", ft_perc=" + ft_perc + ", blk=" + blk + ", stl=" + stl + ", tov=" + tov
				+ ", pf=" + pf + "]";
	}
	
	
	
}