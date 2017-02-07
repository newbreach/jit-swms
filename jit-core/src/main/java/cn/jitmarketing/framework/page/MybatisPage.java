package cn.jitmarketing.framework.page;

import java.util.List;

public class MybatisPage implements java.io.Serializable
{
	private int pageNum = 1; // 当前页(默认为1)
	private int pageSize = 10;// 每页记录数(默认为10)
	private int startRow;// 开始记录
	private int endRow;// 结束记录
	private long total;// 总记录数
	private int pages;// 总页数
	private int firstPage;// 第一页
	private int prePage;// 上一页
	private int nextPage;// 下一页
	private int lastPage;// 最后一页
	private boolean isFirstPage = false;// 是否是第一页
	private boolean isLastPage = false;// 是否是最后一页
	private boolean hasPreviousPage = false;// 是否有上一页
	private boolean hasNextPage = false;// 是否有下一页

	/*
	 * 参数1：总记录数 参数2：每页记录数 参数3：当前页
	 */
	public void init(long totalNum, int pageSize, int currentPage)
	{
		this.pageNum = currentPage;// 当前页
		this.pageSize = pageSize;// 每页记录数
		this.startRow = (currentPage - 1) * this.pageSize;// 开始记录
		this.endRow = this.startRow + this.pageSize;// 结束记录
		this.total = totalNum;// 总记录数
		if (totalNum % pageSize == 0)
		{
			this.pages = (int) (totalNum / pageSize);// 总页数
		} else
		{
			this.pages = (int) (totalNum / pageSize) + 1;// 总页数
		}
		this.firstPage = this.total > 0 ? 1 : 0;// 第一页
		this.lastPage = this.pages;// 最后一页 与总页数相同
		this.prePage = this.pageNum > 0 ? this.pageNum - 1 : 0;// 上一页
		this.nextPage = this.pageNum == this.lastPage ? 0 : this.pageNum + 1;// 下一页

		this.isFirstPage = (this.pageNum == this.firstPage);// 是否是第一页
		this.isLastPage = (this.pageNum == this.lastPage);// 是否是最后一页
		this.hasPreviousPage = (this.pageNum > 1);// 是否有上一页
		this.hasNextPage = (this.pageNum < this.lastPage);// 是否有下一页

	}

	public int getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(int pageNum)
	{
		this.pageNum = pageNum;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getStartRow()
	{
		return startRow;
	}

	public void setStartRow(int startRow)
	{
		this.startRow = startRow;
	}

	public int getEndRow()
	{
		return endRow;
	}

	public void setEndRow(int endRow)
	{
		this.endRow = endRow;
	}

	public long getTotal()
	{
		return total;
	}

	public void setTotal(long total)
	{
		this.total = total;
	}

	public int getPages()
	{
		return pages;
	}

	public void setPages(int pages)
	{
		this.pages = pages;
	}

	public int getFirstPage()
	{
		return firstPage;
	}

	public void setFirstPage(int firstPage)
	{
		this.firstPage = firstPage;
	}

	public int getPrePage()
	{
		return prePage;
	}

	public void setPrePage(int prePage)
	{
		this.prePage = prePage;
	}

	public int getNextPage()
	{
		return nextPage;
	}

	public void setNextPage(int nextPage)
	{
		this.nextPage = nextPage;
	}

	public int getLastPage()
	{
		return lastPage;
	}

	public void setLastPage(int lastPage)
	{
		this.lastPage = lastPage;
	}

	public boolean isFirstPage()
	{
		return isFirstPage;
	}

	public void setFirstPage(boolean isFirstPage)
	{
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage()
	{
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage)
	{
		this.isLastPage = isLastPage;
	}

	public boolean isHasPreviousPage()
	{
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage)
	{
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage()
	{
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage)
	{
		this.hasNextPage = hasNextPage;
	}

}
