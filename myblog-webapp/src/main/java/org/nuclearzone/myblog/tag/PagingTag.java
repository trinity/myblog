package org.nuclearzone.myblog.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PagingTag extends SimpleTagSupport {
	
	private int numberOfPagesToShow = 5;
	private int currentPage;
	private int totalPageCount;
	
	public int getNumberOfPagesToShow() {
		return numberOfPagesToShow;
	}

	public void setNumberOfPagesToShow(int numberOfPagesToShow) {
		this.numberOfPagesToShow = numberOfPagesToShow;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	public PagingTag() {
		super();
	}
	
	@Override
	public void doTag() throws JspException, IOException {
			
		// eg. we are on page 7, floor is 7 - 2 = 5
		int floor = currentPage - currentPage % numberOfPagesToShow;
		
		// eg. we are on page 7, roof is floor + 5 = 10
		int roof = floor + numberOfPagesToShow;
		
		if(roof > totalPageCount) {
			roof = totalPageCount;
		}
		
		JspWriter out = getJspContext().getOut();
		
		if(currentPage > 0) {
			out.println("<ul><li><a href=\"?page=" + (currentPage - 1) + "\">Prev</a></li>");
		} else {
			out.println("<ul><li class=\"disabled\"><a href=\"#\">Prev</a></li>");
		}	
		
		for(int i = floor + 1; i < roof + 1; i++) {
			if(currentPage == i - 1) {
				out.println("<li class=\"disabled\"><a href=\"#\">" + i + "</a></li>");			
			} else {
				out.println("<li><a href=\"?page=" + (i - 1) + "\">" + i + "</a></li>");
			}
		}

		if(totalPageCount > (currentPage + 1)) {
			out.println("<li><a href=\"?page=" + (currentPage + 1) + "\">Next</a></li></ul>");
		} else {
			out.println("<li class=\"disabled\"><a href=\"#\">Next</a></li></ul>");
		}
	}
}