FROM nginx:latest
RUN rm /etc/nginx/conf.d/default.conf
COPY ./config/ /etc/nginx/conf.d/
COPY ./content /usr/share/nginx/html