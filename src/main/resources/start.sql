

CREATE TABLE public.devices (
                         id SERIAL PRIMARY KEY,
                         name TEXT,
                         installation_date DATE,
                         max_connections INT
);


CREATE TABLE public.ports (
                       id SERIAL PRIMARY KEY,
                       device_id INTEGER,
                       name TEXT,
                       bandwidth INTEGER
);


INSERT
INTO public.devices (name, installation_date, max_connections)
VALUES
    ('C0MF_CNTRL1', '2015-11-04', 2),
    ('C0MX_CNTRL23', '2014-01-11', 6),
    ('C0RU_CNTRL90', '2010-12-20', 5),
    ('C0AZ_CNTRL27', '2015-07-01', NULL),
    ('C0XX_CNTRL76', '2013-06-08', NULL),
    ('C0AZ_CNTRL99', '2015-07-20', 3),
    ('C0BM_CNTRL100', '2012-12-14', NULL);


INSERT
INTO public.devices (name, installation_date, max_connections)
VALUES
    ('TEST1', '2025-05-09', 33),
    ('TEST2', '2025-05-09', 33);


INSERT INTO public.devices (name, installation_date, max_connections)
VALUES
    ('TEST_1', '2025-05-09', 33),
    ('TEST_2', '2025-05-09', 33);


INSERT INTO public.ports (device_id, name, bandwidth)
VALUES
    (1, 'Port 1', 2),
    (1, 'Port 2', 3),
    (2, 'Port x', 4);

SELECT * FROM public.devices;

DROP TABLE public.devices;
DROP TABLE public.ports;