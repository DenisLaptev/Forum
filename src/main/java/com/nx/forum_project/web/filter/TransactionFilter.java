package com.nx.forum_project.web.filter;

import com.nx.forum_project.data.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
@Order(1)
public class TransactionFilter implements Filter {

    private final static Logger LOG = LoggerFactory.getLogger(TransactionFilter.class);

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

        LOG.info("Initializing filter :{}", this);

    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        Session session = HibernateUtil.currentSession();

        LOG.info("Starting a transaction for req : {}", req.getRequestURI());
        Transaction transaction = session.beginTransaction();

        try {
            chain.doFilter(request, response);

            LOG.info("Committing a transaction for req : {}", req.getRequestURI());
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            HibernateUtil.closeCurrentSession();
        }
    }

    @Override
    public void destroy() {

        LOG.warn("Destructing filter :{}", this);

    }

}
